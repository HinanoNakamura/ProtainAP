<template>
  <div>
    <form @submit.prevent="registerUser">
      <div class="newfont">新規登録</div>
      <br><br>
      <label for="username">ユーザーID:</label>
      <input type="text" id="username" v-model="username">
      <br><br>
      <label for="password">Password:</label>
      <input type="password" id="password" v-model="password">
      <br>
      <label for="password-confirm">Confirm Password:</label>
      <input type="password" id="password-confirm" v-model="passwordConfirm">
      <br>
      <span v-if="password !== passwordConfirm">Passwords do not match</span>
      <br>
      <br>
      <div v-if="imageUrl">
        <img :src="imageUrl" alt="uploaded-image">
        <croppa ref="croppa" v-model="croppedImageUrl"></croppa>
      </div>
      <input type="file" accept="image/*" @change="uploadImage" />
      <button>登録</button>  
    </form>

    <div class="back-home">
      <button v-if="$route.path !== '/'" @click="$router.push('/')">ホーム画面に戻る</button>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import {Service} from "@/store/index.js"
import Croppa from 'vue-croppa'

export default {
  name: 'UserRegistration',
  components: {
    Croppa
  },
  data() {
    return {
      username: '',
      password: '',
      passwordConfirm: '',
      imageUrl: '',
      imageFile: null,
      croppedImageUrl: null
    };
  },
  methods: {
    registerUser() {
      const userData = {
        id: this.username,
        password: this.password,
        icon: '炙り中トロ',
      };
      Service.post('/api/users', userData)
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    uploadImage(event) {
      const file = event.target.files[0]
      this.imageUrl = URL.createObjectURL(file)
      this.imageFile = file
    },
    saveCroppedImage() {
      this.$refs.croppa.generateBlob((blob) => {
        this.croppedImageUrl = URL.createObjectURL(blob)
      }, 'image/jpeg', 0.8)
    }
  }
};
</script>

<style>
form {
  text-align: center;
}

.back-home button{
  text-align: center;
  border-radius: 100vh;
}

.newfont {
  font-size: 30px;
}
</style>