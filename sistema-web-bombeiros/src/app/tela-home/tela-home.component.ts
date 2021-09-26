import { Component, OnInit } from '@angular/core';
import { Loader } from '@googlemaps/js-api-loader';

let map: google.maps.Map;
const additionalOptions = {};

const loader = new Loader({
  apiKey: "AIzaSyBfI3hYngg-0jzy9YAJRP-mGAcU5yHMJzw",
  version: "weekly",
  ...additionalOptions,
});

loader.load().then(() => {
  map = new google.maps.Map(document.getElementById("map") as HTMLElement, {
    center: { lat: -34.397, lng: 150.644 },
    zoom: 15,
  });
});

@Component({
  selector: 'app-tela-home',
  templateUrl: './tela-home.component.html',
  styleUrls: ['./tela-home.component.scss']
})
export class TelaHomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}

export {map};
