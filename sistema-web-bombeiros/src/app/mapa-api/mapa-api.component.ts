import { NominatimService } from './../services/nominatim.service';
import { EdificacoesService } from './../services/edificacoes.service';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Feature, View } from 'ol';
import Map from 'ol/Map';
import { XYZ, OSM, Cluster, Vector as VectorSource } from 'ol/source';
import { Tile as TileLayer, Vector as VectorLayer } from 'ol/layer';
import * as Proj from 'ol/proj.js';
import Point from 'ol/geom/Point';
import { Circle as CircleStyle, Fill, Stroke, Style, Text } from 'ol/style';
import { boundingExtent } from 'ol/extent';
import Overlay from 'ol/Overlay';

@Component({
  selector: 'app-mapa-api',
  templateUrl: './mapa-api.component.html',
  styleUrls: ['./mapa-api.component.scss'],
})
export class MapaApiComponent implements OnInit {
  @ViewChild('popup') element!: ElementRef;
  popup!: Overlay;
  display: string = 'none';

  constructor(
    private edificacoesService: EdificacoesService,
    nominatimService: NominatimService
  ) {}
  pontos: any;

  async ngAfterViewInit() {
    this.pontos = await this.edificacoesService.list();
    const map = this.criarMapa();
    // const cluster = this.criarCluster();
    // map.addLayer(cluster);
    // this.ouvirClickMapa(map, cluster);
    this.addCluster(map);
  }

  async ngOnInit() {}
  private ouvirClickMapa(evt: any, map: Map, cluster: any) {
    map.on('click', (evento) => {
      this.display = 'none';
      cluster.getFeatures(evento.pixel).then((clickedFeatures: any) => {
        if (clickedFeatures.length) {
          // Get clustered Coordinates
          const features = clickedFeatures[0].get('features');
          if (features.length > 1) {
            const extent = boundingExtent(
              features.map((r: any) => r.getGeometry().getCoordinates())
            );
            map
              .getView()
              .fit(extent, { duration: 1000, padding: [50, 50, 50, 50] });
          } else if (features.length == 1) {
            this.insertOverlay(evt, features[0].get('data'));
          }
        }
      });
    });
  }

  private addCluster(map: Map) {
    const features: any[] = [];
    for (let i = 0; i < this.pontos.length; ++i) {
      const ponto = Proj.fromLonLat([
        this.pontos[i].longitude,
        this.pontos[i].latitude,
      ]);
      features[i] = new Feature(new Point(ponto));
    }
    const clustersR = this.createCluster(
      features.slice(0, features.length / 3),
      '#f00'
    );
    const clustersG = this.createCluster(
      features.slice(features.length / 3, (2 * features.length) / 3),
      '#0f0'
    );
    const clustersB = this.createCluster(
      features.slice((2 * features.length) / 3, features.length),
      '#00f'
    );
    map.addLayer(clustersR);
    map.addLayer(clustersG);
    map.addLayer(clustersB);

    map.on('click', (e) => {
      this.display = 'none';
      clustersR
        .getFeatures(e.pixel)
        .then((clickedFeatures: any) =>
          this.clickCluster(e, clickedFeatures, map)
        );
      clustersG
        .getFeatures(e.pixel)
        .then((clickedFeatures: any) =>
          this.clickCluster(e, clickedFeatures, map)
        );
      clustersB
        .getFeatures(e.pixel)
        .then((clickedFeatures: any) =>
          this.clickCluster(e, clickedFeatures, map)
        );
    });
  }

  private clickCluster(evt: any, clickedFeatures: any, map: Map) {
    if (clickedFeatures.length) {
      const features = clickedFeatures[0].get('features');
      if (features.length > 1) {
        const extent = boundingExtent(
          features.map((r: any) => r.getGeometry().getCoordinates())
        );
        map
          .getView()
          .fit(extent, { duration: 1000, padding: [50, 50, 50, 50] });
      } else if (features.length == 1) {
        this.insertOverlay(evt, features[0].get('data'));
      }
    }
  }

  private criarMapa() {
    const raster = new TileLayer({
      source: new XYZ({
        url: 'https://mt1.google.com/vt/lyrs=r&x={x}&y={y}&z={z}&apistyle=s.t%3A1%7Cp.v%3Aon%2Cs.t%3A21%7Cs.e%3Al.i%7Cp.v%3Aon%2Cs.t%3A2%7Cp.v%3Aoff%2Cs.t%3A2%7Cs.e%3Al.i%7Cp.v%3Aoff%2Cs.t%3A33%7Cp.v%3Aoff%2Cs.t%3A33%7Cs.e%3Al.i%7Cp.v%3Aoff%2Cs.t%3A3%7Cs.e%3Al.i%7Cp.v%3Aoff%2Cs.t%3A51%7Cs.e%3Al.i%7Cp.v%3Aoff%2Cs.t%3A4%7Cp.v%3Aoff',
      }),
    });

    const map = new Map({
      layers: [raster],
      target: 'map',
      view: new View({
        center: Proj.fromLonLat([-48.635454, -27.617852]),
        zoom: 14,
      }),
    });

    return map;
  }

  private criarCluster() {
    const features: any[] = [];
    for (let i = 0; i < this.pontos.length; ++i) {
      const ponto = Proj.fromLonLat([
        this.pontos[i].longitude,
        this.pontos[i].latitude,
      ]);
      features[i] = new Feature(new Point(ponto));
    }

    const source = new VectorSource({
      features: features,
    });

    const clusterSource = new Cluster({
      distance: 80,
      source: source,
    });

    const styleCache: any = {};
    const clusters = new VectorLayer({
      source: clusterSource,
      style: function (feature) {
        const size = feature.get('features').length;
        let style = styleCache[size];
        if (!style) {
          style = new Style({
            image: new CircleStyle({
              radius: 15,
              stroke: new Stroke({
                color: '#fff',
              }),
              fill: new Fill({
                color: '#DC3545',
              }),
            }),
            text: new Text({
              text: size.toString(),
              fill: new Fill({
                color: '#fff',
              }),
            }),
          });
          styleCache[size] = style;
        }
        return style;
      },
    });

    return clusters;
  }

  private createCluster(features: any, color: string) {
    const source = new VectorSource({
      features,
    });

    const clusterSource = new Cluster({
      distance: 80,
      source: source,
    });

    const styleCache: any = {};

    const clusters = new VectorLayer({
      source: clusterSource,
      style: function (feature) {
        const size = feature.get('features').length;
        let style = styleCache[size];
        if (!style) {
          style = new Style({
            image: new CircleStyle({
              radius: 10,
              stroke: new Stroke({
                color: '#fff',
              }),
              fill: new Fill({
                color,
              }),
            }),
            text: new Text({
              text: size.toString(),
              fill: new Fill({
                color: '#fff',
              }),
            }),
          });
          styleCache[size] = style;
        }
        return style;
      },
    });
    return clusters;
  }

  private insertOverlay(evt: any, data: Record<string, any>) {
    this.display = 'block';
    const element = this.popup.getElement()!;
    const coordinate = evt.coordinate;
    element.innerHTML = `<div><span>Nome: ${data.nome}</span><br><span>Rua: ${data.endereco}</span><br><span>Cep: ${data.cep}</span><br><span>Telefone: ${data.telefone1}</span></div>`;
    this.popup.setPosition(coordinate);
  }
}
