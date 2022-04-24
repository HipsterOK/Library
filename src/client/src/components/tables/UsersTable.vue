<template>
  <div>
    <table class="table table-striped" v-if="users && users.length">
      <thead class="table-dark">
      <tr>
        <th scope="col">id</th>
        <th scope="col">Фамилия</th>
        <th scope="col">Имя</th>
        <th scope="col">Отчество</th>
        <th scope="col">Управление</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="user of users" :key="user">
        <td>{{ user.id }}</td>
        <td>{{ user.surname }}</td>
        <td>{{ user.name }}</td>
        <td>{{ user.patronymic }}</td>
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
      users: [],
      errors: []
    }
  },
  methods: {
    editUser: function(user) {
      console.log('User id of ' + user.id)
    },
    removeUser: function(user) {
      console.log('User id of ' + user.id)
    }
  },
  created() {
    axios.get(`http://localhost:8080/user/`).then(response => {
      this.users = response.data
    }).catch(e => {
      this.errors.push(e)
    })
  }
}
</script>