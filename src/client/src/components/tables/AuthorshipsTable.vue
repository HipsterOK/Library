<template>
  <div>
    <table class="table table-striped" v-if="authorships && authorships.length">
      <thead class="table-dark">
      <tr>
        <th scope="col">id</th>
        <th scope="col">Книга</th>
        <th scope="col">Автор</th>
        <th scope="col">Управление</th>

      </tr>
      </thead>
      <tbody>
      <tr v-for="authorship of authorships" :key="authorship">
        <td>{{ authorship.id }}</td>
        <td>{{ authorship.bookId.title }}</td>
        <td>{{ authorship.authorId.name }}</td>
        <td>
          <button class="btn btn-secondary" style="margin-right:10px;" @click="editAuthorship(authorship)">Изм.</button>
          <button class="btn btn-danger" @click="removeAuthorship(authorship)">Удалить</button>
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
      authorships: [],
    }
  },
  methods: {
    editAuthorship: function(authorship) {
      console.log('Authorship id: ' + authorship.id)
    },
    removeAuthorship: function(authorship) {
      console.log('Authorship id: ' + authorship.id)
    }
  },
  created() {
    axios.get(`http://localhost:8080/authorship/`).then(response => {
      this.authorships = response.data
    })
  }
}
</script>