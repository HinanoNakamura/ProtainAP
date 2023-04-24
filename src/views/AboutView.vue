<template>


  <div id="app" style="align: center;">
    <div>
      <!-- <span>ID:</span>
      <input
        type="number"
        id="testes-id"
        style="margin-right: 10px;"
        v-model="testesId"/> -->
        <h1>💩君もプロテインマスターにならないか？💩</h1>
      <button
        @click="search()">押しちゃう？？</button>
    </div>
    <!-- <div v-if="result">
      <h1>{{ result}}</h1>
      <br>
      <span>{{ result }}</span>
      <br>
      <span>{{ result }}</span>
    </div> -->
    <ul v-for="result in results" :key="result.id">
      <h1>💗おすすめプロテイン💗</h1>
      <h2>{{ "名前：" + result.name }} </h2>
  <h2>{{"価格:" + result.price }}</h2>
  <li ><img v-bind:src="result.img" alt="result.img"></li>
</ul>

<br>

  </div>
 
</template>

<script>
import {Service} from "@/store/index.js"

export default {
  name: 'App',
  data(){
    return{
      testesId:null,
      // result:"",
      results:[],
      name: '',
      pass: '',
      isValidName: true,
      isValidPass: true
    }
  },
  methods:{
    search(){
      Service.get("/users").then(response => {
        if(!response.data){
          this.result="NO DATA"
        }else{
          this.results=response.data
          // this.$router.push('/users')
        }
      })
    },
    
    submitForm() {
    this.isValidName = this.name !== '';
    this.isValidPass = this.pass !=='';
    if (!this.isValidName || !this.isValidPass) {
      // エラーメッセージを表示して、送信を中止する
      return;
    }

    alert('本当にいいの？')
    }
  }
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>