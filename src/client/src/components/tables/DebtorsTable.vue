<template>
    <div>
        <table class="table table-striped" v-if="debtors && debtors.length">
            <thead class="table-dark">
            <tr>
                <th scope="col">ФИО пользователя</th>
<!--                <th scope="col">Номер телефона</th>-->
                <th scope="col">Название книги</th>
                <th scope="col">Автор</th>
                <th scope="col">Дата сдачи</th>
                <th scope="col">Управление</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="debtor of debtors" :key="debtor">
                <td>{{ debtor.userFullName }}</td>
                <td>{{ debtor.bookTitle }}</td>
                <td>{{ debtor.bookAuthorFullName }}</td>
                <td>{{ debtor.deliveryDate }}</td>
                <td>
                    <button class="btn btn-secondary" style="margin-right:10px;" @click="editDebtor(debtor)">
                        Изм.
                    </button>
                    <button class="btn btn-danger" @click="removeDebtor(debtor)">Удалить</button>
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
                debtors: [],
            }
        },
        methods: {
            editDebtor: function (debtor) {
                console.log('Debtor name: ' + debtor[0])
            },
            removeDebtor: function (debtor) {
                console.log('Debtor name: ' + debtor[0])
            }
        },
        created() {
            axios.get(`http://localhost:8081/issuance/debtors`).then(response => {
                this.debtors = response.data
            })
            console.log(this.debtors.length)
        }
    }
</script>