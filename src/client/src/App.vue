<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/book">Книги</router-link> |
    <router-link to="/author">Авторы</router-link> |
    <router-link to="/user">Пользователи</router-link> |
    <router-link to="/genre">Жанры</router-link> |
    <router-link to="/authorship">Авторство</router-link> |
    <router-link to="/issuance">Выдачи</router-link> |
    <router-link to="/debtors">Должники</router-link> |
    <router-link to="/userBooks">Мои книги</router-link>
  </nav>
  <router-view/>
</template>

<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
