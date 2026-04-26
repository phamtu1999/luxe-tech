import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/shop',
      name: 'shop',
      component: () => import('../views/ProductListView.vue')
    },
    {
      path: '/product/:id',
      name: 'product-detail',
      component: () => import('../views/ProductDetailView.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/LoginView.vue')
    },
    {
      path: '/cart',
      name: 'cart',
      component: () => import('../views/CartView.vue')
    },
    {
      path: '/checkout',
      name: 'checkout',
      component: () => import('../views/CheckoutView.vue')
    },
    {
      path: '/order-tracking/:id',
      name: 'order-tracking',
      component: () => import('../views/OrderTrackingView.vue')
    },
    {
      path: '/admin',
      name: 'admin',
      component: () => import('../views/AdminDashboardView.vue')
    },
    {
      path: '/admin/products',
      name: 'admin-products',
      component: () => import('../views/AdminProductsView.vue')
    },
    {
      path: '/admin/products/add',
      name: 'admin-add-product',
      component: () => import('../views/AdminAddProductView.vue')
    },
    {
      path: '/admin/orders',
      name: 'admin-orders',
      component: () => import('../views/AdminOrdersView.vue')
    },
    {
      path: '/admin/coupons',
      name: 'admin-coupons',
      component: () => import('../views/AdminCouponsView.vue')
    },
    {
      path: '/search',
      name: 'search',
      component: () => import('../views/SearchView.vue')
    },
    {
      path: '/support',
      name: 'support',
      component: () => import('../views/SupportView.vue')
    },
    {
      path: '/comparison',
      name: 'comparison',
      component: () => import('../views/ComparisonView.vue')
    },
    {
      path: '/blog',
      name: 'blog',
      component: () => import('../views/BlogView.vue')
    },
    {
      path: '/account',
      name: 'account',
      component: () => import('../views/AccountView.vue')
    },
    {
      path: '/:pathMatch(.*)*',
      name: 'not-found',
      component: () => import('../views/NotFoundView.vue')
    }
  ]
})

export default router
