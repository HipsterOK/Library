import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/book/',
    name: 'books',
    component: () => import(/* webpackChunkName: "about" */ '../views/BooksView.vue')
  },
  {
    path: '/bookCopy/:id',
    name: 'book',
    component: () => import(/* webpackChunkName: "about" */ '../views/SingleBookView.vue')
  },
  {
    path: '/author',
    name: 'authors',
    component: () => import(/* webpackChunkName: "about" */ '../views/AuthorsView.vue')
  },
  {
    path: '/user',
    name: 'users',
    component: () => import(/* webpackChunkName: "about" */ '../views/UsersView.vue')
  },
  {
    path: '/genre',
    name: 'genre',
    component: () => import(/* webpackChunkName: "about" */ '../views/GenresView.vue')
  },
  {
    path: '/authorship',
    name: 'authorship',
    component: () => import(/* webpackChunkName: "about" */ '../views/AuthorshipsView.vue')
  },
  {
    path: '/issuance',
    name: 'issuances',
    component: () => import(/* webpackChunkName: "about" */ '../views/IssuancesView.vue')
  },
  {
    path: '/debtors',
    name: 'debtors',
    component: () => import(/* webpackChunkName: "about" */ '../views/DebtorsView.vue')
  },
  {
    path: '/userBooks',
    name: 'userBooks',
    component: () => import(/* webpackChunkName: "about" */ '../views/UserBooksView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
