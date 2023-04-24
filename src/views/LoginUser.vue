<template>
  <div>
    <form>
      <div class ="newfont">ログイン</div>
      <br><br>
      <label for="username">ユーザーID:</label>
      <input type="text" id="username" v-model="username">
      <div v-if="!isValidName" class="error-message">名前は必須です。</div>
      <br><br>
      <label for="password">パスワード:</label>
      <input type="password" id="password" v-model="password">
      <div v-if="!isValidPass" class="error-message">パスワードを入力してください。</div>
      <div id="app">
        <button @click="login($event)">ログイン</button>
      </div>
      <p>{{ loginMsg }}</p>
      <br>
      <div class="flex">
        <router-link to="/register">登録がまだの方はこちら 新規登録</router-link>
      </div>
    </form>
    <div class="back-home">
      <button v-if="$route.path !== '/'" @click="$router.push('/')">ホーム画面に戻る</button>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import {Service} from "@/store/index.js"
export default {
  data() {
    return {
      username: '',
      password: '',
      isValidName: true,
      isValidPass: true,
      loginMsg: '',
    }
  },
  methods: {
    login(event) {
      event.preventDefault();
      this.isValidName = this.username !== '';
      this.isValidPass = this.password !== '';
      if (!this.isValidName || !this.isValidPass) {
        // エラーメッセージを表示して、送信を中止する
        return;
      } else {
        Service.post('/login', {
          id: this.username,
          password: this.password
        })
        .then(response => {
          this.loginMsg = 'ログイン成功';
          console.log(response);
        })
        .catch(error => {
          this.loginMsg = 'ユーザーIDかパスワードをちゃんと確認しろ😩';
          console.log(error);
        });
      }
    }
  }
}


</script>

<style>
form {
  text-align: center;
}

.back-home {
  text-align: center;
}

.newfont {
  font-size: 30px;
}
</style>
