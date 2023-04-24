<template>
  <div style="font-size: 14px; text-align: center; width: 100vw;">
    <h2>画像のトリミング</h2>
    <hr>
    <h3>画像を選択</h3>
    <br>
    <div
      v-if="imgSrc !== ''"
      class="l_cropper_container"
      style="width: 600px; height: 600px;"
    >
      <vue-cropper
        ref="cropper"
        :guides="true"
        :view-mode="2"
        :auto-crop-area="0.5"
        :min-container-width="600"
        :min-container-height="600"
        :background="true"
        :rotatable="false"
        :src="imgSrc"
        :img-style="{ 'width': '800px', 'height': '800px' }"
        :aspect-ratio="targetWidth / targetHeight"
        drag-mode="crop"
      />
      <br>

      <button @click="cropImage">
        トリミング
      </button>
    </div>

    <div imageUrl>
      <croppa ref="croppa" v-model="croppedImageUrl"></croppa>
      <br>
      <br>
      <br>
      <div v-if="croppedImageUrl !== ''">
        <img
          :src="croppedImageUrl"
          alt="Cropped Image"
          class="c_cropped_image"
        >
        <p>
          <a :href="imageUrl" :download="filename">画像を保存</a>


        </p>
        <br>
      </div>
    </div>
    <input type="file" accept="image/*" @change="uploadImage" />
  </div>
</template>

<script>
import VueCropper from 'vue-cropperjs'
import 'cropperjs/dist/cropper.css'

export default {
  components: {
    VueCropper
  },
  data() {
    return {
      targetWidth: 1,
      targetHeight: 1,
      imgSrc: '',
      filename: '',
      croppedImageUrl: '',
      imageUrl: ''
    }
  },
  methods: {
    setImage(e) {
      const file = e.target.files[0]
      this.filename = file.name
      if (!file.type.includes('image/')) {
        alert('Please select an image file')
        return
      }
      if (typeof FileReader === 'function') {
        const reader = new FileReader()
        reader.onload = (event) => {
          this.imgSrc = event.target.result
        }
        reader.readAsDataURL(file)
      } else {
        alert('Sorry, FileReader API not supported')
      }
    },
    onCropperReady() {
      this.cropImage()
    },
    cropImage() {
  const canvas = this.$refs.cropper.getCroppedCanvas()
  canvas.toBlob((blob) => {
    this.imageUrl = URL.createObjectURL(blob)
  })
},
    uploadImage(event) {
      const file = event.target.files[0]
      this.imageUrl = URL.createObjectURL(file)
      this.setImage(event)
    }
  }
}
</script>
  
  <style scoped>
  h2 {
    font-size: 25px;
    margin-top: 20px;
  }
  h3 {
    font-size: 20px;
  }
  .c_cropped_image {
  max-width: 100%;
  height: auto;
  border: 1px solid gray;
  }
  .l_cropper_container {
    width: 500px;
    height: 500px;
    border: 1px solid gray;
    display: inline-block;
  }
  </style>
  