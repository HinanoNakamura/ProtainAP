<template>
    <div class="今月のおすすめ">
      <h1>今月のおすすめプロテイン一覧</h1>
  
    <div class="flexitem">
      <img src="frontend/src/assets/81BC0hSJ-ZL.jpg" alt="サンプル画像">
      <p>>ザバス ココア味</p>
      <a href="">詳細を見る</a>
    </div>
  
    <div class="flexitem">
      <img src="frontend/src/assets/000000000763_6lK7Cxx.jpg" alt="サンプル画像">
      <p>DNS いちご味</p>
      <a href="">詳細を見る</a>
    </div>
    </div>
  </template>
  
  <style>
    body {
      max-width: 1000px;
      margin: auto;
    }
    .flexbox {
      display: flex;
      justify-content: space-between;
      flex-flow: row wrap;
    }
    .flexitem {
      flex: 0 0 24%;
    }
    .flexitem img {
      display: block;
      width: 100%;
      height: 200px;
      object-fit: contain;
    }
    .flexitem a {
      display: block;
      background-color: blue;
      color: #fff;
      padding: 5px 10px;
      border-radius: 5px;
      font-size: 12px;
      margin: auto;
      max-width: 80px;
      text-align: center;
      text-decoration: none;
    }
  </style>