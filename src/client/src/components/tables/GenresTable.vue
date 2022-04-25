<template>
  <div>
    <table class="table table-striped" v-if="genres && genres.length">
      <thead class="table-dark">
      <tr>
        <th scope="col">id</th>
        <th scope="col">Жанр</th>
        <th scope="col">Управление</th>

      </tr>
      </thead>
      <tbody>
      <tr v-for="genre of genres" :key="genre">
        <td>{{ genre.id }}</td>
        <td>{{ genre.name }}</td>
        <td>
          <button class="btn btn-secondary" style="margin-right:10px;" @click="editUser(user)">Изм.</button>
          <button class="btn btn-danger" @click="removeUser(user)">Удалить</button>
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
      genres: [],
      errors: []
    }
  },
  methods: {
    editUser: function(genre) {
      console.log('Genre id of ' + genre.id)
    },
    removeUser: function(genre) {
      console.log('Genre id of ' + genre.id)
    }
  },
  created() {
    axios.get(`http://localhost:8080/genre/`).then(response => {
      this.genres = response.data
    }).catch(e => {
      this.errors.push(e)
    })
  }
}
</script>