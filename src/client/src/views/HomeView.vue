<template>
  <div class="home">
    <img class="logo-img" alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Проект библиотеки Уфанет!"/>
  </div>
</template>

<script>
import HelloWorld from '@/views/GreetingView.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
</script>

<style>
  .logo-img {
    width: 25%;
  }
</style>

