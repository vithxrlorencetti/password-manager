import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'password-list',
    component: () => import(/* webpackChunkName: "list" */ '../views/password/password-list.vue')
  },
  {
    path: '/password/form',
    name: 'password-insert',
    component: () => import(/* webpackChunkName: "form" */ '../views/password/password-form.vue')
  },
  {
    path: '/password/form/:model/:id',
    name: 'password-details',
    props: (router) => ({ id: router.params.id, model: router.params.model }),
    component: () => import(/* webpackChunkName: "form" */ '../views/password/password-form.vue')
  },
  {
    path: '/password/form/:model/:id',
    name: 'password-edit',
    props: (router) => ({ id: router.params.id, model: router.params.model }),
    component: () => import('../views/password/password-form.vue')
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
