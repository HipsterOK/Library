<template>
  <div>
    <table class="table table-striped" v-if="authors && authors.length">
      <thead class="table-dark">
      <tr>
        <th scope="col">id</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Имя</th>
        <th scope="col">Отчество</th>
        <th scope="col">Описание</th>
        <th scope="col">Управление</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="author of authors" :key="author">
        <td>{{ author.id }}</td>
        <td>{{ author.surname }}</td>
        <td>{{ author.name }}</td>
        <td>{{ author.patronymic }}</td>
        <td>{{ author.description }}</td>
        <td>
          <button class="btn btn-secondary" style="margin-right:10px;" @click="editAuthor(author)">Изм.</button>
          <button class="btn btn-danger" @click="removeAuthor(author)">Удалить</button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      authors: [],
    }
  },
  methods: {
    editAuthor: function(author) {
      console.log('Author id: ' + author.id)
    },
    removeAuthor: function(author) {
      console.log('Author id: ' + author.id)
    }
  },
  created() {
    axios.get(`http://localhost:8080/author/`).then(response => {
      this.authors = response.data
    })
  }
}
</script>