<template>
    <div class="home">
      <img alt="Protein" src="frontend/src/assets/20210810_atliving_protein_main-760x507.jpg">
      <HelloWorld msg="Welcome to Proteinworld"/>
    </div>
  </template>
<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
export default {
  name: 'ProteinMain',
  components: {
    HelloWorld
  }
}
</script>