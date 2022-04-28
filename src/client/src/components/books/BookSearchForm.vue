<template>
  <div id="v-model-select" class="demo">
    <select v-model="selected">
      <option disabled value="">Выберите один из вариантов</option>
      <option>А</option>
      <option>Б</option>
      <option>В</option>
    </select>
    <span>Выбрано: {{ selected }}</span>
  </div>
</template>

<script>
export default {
  name: "BookSearchForm"
}
</script>

<style scoped>

</style>