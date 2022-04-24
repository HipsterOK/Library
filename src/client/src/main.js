import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import store from '@/store'

const app = createApp(App)
app.use(store).use(router).mount('#app')