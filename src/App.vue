<template>
  <div>
    <div class="home">
      <img alt="Protein" src="./assets/20210810_atliving_protein_main-760x507.jpg">
      <HelloWorld msg="Welcome to Proteinworld"/>
    </div>

  <div class="flavor-selector">
    <h3>FLAVOR</h3>
    <div v-for="(flavor, index) in flavors" :key="index" class="flavor-option">
      <input type="checkbox" :id="'flavor-' + index" v-model="selectedFlavors" :value="flavor">
      <label :for="'flavor-' + index">{{ flavor }}</label>
    </div>
    <!-- <p>Selected flavors: {{ selectedFlavors }}</p>
    <p>あいかちゃん: {{ selectedFlavors.map(flavor => flavors.indexOf(flavor) + 1) }}</p> -->
  </div>

  <div class="flavor-selector">
  <h3>PURPOSE</h3>
  <div v-for="(purpose, index) in purposes" :key="index" class="flavor-option">
    <input type="checkbox" :id="'purpose-' + index" v-model="selectedPurposes" :value="purpose">
    <label for="'purpose-' + index">{{ purpose }}</label>
  </div>
    <!-- <p>Selected purposes: {{ selectedPurposes }}</p>
    <p>ともちゃん: {{ selectedPurposes.map(purpose => purposes.indexOf(purpose) + 1) }}</p> -->

  </div>

  <div class="flavor-selector">
  <h3>COMPONENT</h3>
  <div v-for="(component, index) in components" :key="index" class="flavor-option">
    <input type="checkbox" :id="'component-' + index" v-model="selectedComponents" :value="component">
    <label for="'component-' + index">{{ component }}</label>
  </div>
  <!-- <p>Selected components: {{ selectedComponents }}</p>
  <p>なるお: {{ selectedComponents.map(component => components.indexOf(component) + 1) }}</p> -->
</div>

<div class="flavor-selector">
  <h3>PRICE</h3>
  <div v-for="(price, index) in prices" :key="index" class="flavor-option">
    <input type="checkbox" :id="'price-' + index" v-model="selectedPrices" :value="price">
    <label for="'price-' + index">{{ price }}</label>
  </div>
  <!-- <p>Selected prices: {{ selectedPrices }}</p>
  <p>ミーナ: {{ selectedPrices.map(price => prices.indexOf(price) + 1) }}</p> -->
</div>
<button @click="sendFlavors">search</button>

  </div>
</template>

<script>
import {Service} from "@/store/index.js"
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'ProteinMain',
  components: {
    HelloWorld
  },
  data() {
    return {
      flavors: ['いちご', 'マンゴー', 'メロン', 'ココア', '抹茶'],
      selectedFlavors: [],
      purposes: ['ダイエット','筋トレ'],
      selectedPurposes:[],
      components: ['ホエイ','ソイ','カゼイ'],
      selectedComponents:[],
      prices: ['~¥2,000','¥2,001~¥3,000','¥3,001~'],
      selectedPrices:[]
    }
  },
  methods: {
    sendFlavors() {
      const data = {
        flavors: this.selectedFlavors.map(flavor => this.flavors.indexOf(flavor) + 1),
        purposes: this.selectedPurposes.map(purpose => this.purposes.indexOf(purpose) + 1),
        components: this.selectedComponents.map(component => this.components.indexOf(component) + 1),
        prices: this.selectedPrices.map(price => this.prices.indexOf(price) + 1)
      };
      Service.post('/api/flavors', data)
        .then(response => {
          console.log(response.data);
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
}
</script>



<style>
body {
  text-align: center;
}

.home {
  display: flex;
  justify-content: center;
}

.flavor-selector {
  margin-top: 20px; /* 上部の余白を設定 */
  display: flex;
  flex-direction: column;
  align-items: center;
  font-size: 1.2rem;
}

.flavor-option label {
  margin-left: 10px; /* ラベルとラジオボタンの間隔を設定 */
}


</style>