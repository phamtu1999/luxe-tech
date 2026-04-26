<script setup lang="ts">
import { RouterLink, useRoute } from 'vue-router'
import { computed } from 'vue'

const route = useRoute()

const menuItems = [
  { name: 'Bảng điều khiển', icon: 'dashboard', path: '/admin' },
  { name: 'Sản phẩm', icon: 'inventory_2', path: '/admin/products' },
  { name: 'Đơn hàng', icon: 'shopping_cart', path: '/admin/orders' },
  { name: 'Mã giảm giá', icon: 'sell', path: '/admin/coupons' },
]

const isActive = (path: string) => {
  if (path === '/admin') return route.path === '/admin'
  return route.path.startsWith(path)
}

const pageTitle = computed(() => {
  const current = menuItems.find(item => isActive(item.path))
  return current ? current.name : 'LUXE-TECH Admin'
})
</script>

<template>
  <div class="bg-background text-on-background min-h-screen flex">
    <!-- Sidebar -->
    <aside class="fixed left-0 top-0 h-screen w-64 border-r border-transparent bg-blue-950 flex flex-col py-8 z-50">
      <div class="px-8 mb-12">
        <h1 class="text-xl font-black tracking-widest text-white uppercase font-inter">LUXE-TECH</h1>
        <p class="text-[10px] text-blue-300 font-black tracking-[0.2em] mt-1 uppercase opacity-60">Enterprise Suite</p>
      </div>

      <nav class="flex-1 px-4 space-y-2">
        <RouterLink 
          v-for="item in menuItems" 
          :key="item.path"
          :to="item.path"
          class="flex items-center gap-4 px-6 py-4 rounded-2xl transition-all duration-300 font-inter text-[10px] font-black uppercase tracking-widest"
          :class="isActive(item.path) ? 'bg-white/10 text-white shadow-lg shadow-black/10' : 'text-blue-300 hover:bg-white/5 hover:text-white'"
        >
          <span class="material-symbols-outlined text-lg" :style="isActive(item.path) ? 'font-variation-settings: \'FILL\' 1' : ''">{{ item.icon }}</span>
          {{ item.name }}
        </RouterLink>
      </nav>

      <div class="px-4 mt-auto">
        <div class="flex items-center gap-4 p-4 rounded-[2rem] bg-white/5 border border-white/5 group hover:bg-white/10 transition-all cursor-pointer">
          <img class="w-10 h-10 rounded-full border-2 border-white/20 object-cover" src="https://lh3.googleusercontent.com/aida-public/AB6AXuBtf9wrRJEgnqZaM6CEw_2ep3sGjIs3BoiwN_2SONSHq6VCVeJJrQNySM1Kylu9TiqNljZ9M2vuYnobovvqAC6tD-HlEEEeTefp4QZ-36k3mXWVvpvJjcUqcupoFBUdqL0Q5ara9f1aW0ddMPFm72JnJrWjCubPLZT11Rlxlp_9ZT4ku5P96Y5fp82ymoWsDLvoHdYAoI3daY_9gwAJ4CWl_uOaER8N7o2gUC8XoqzrEBK8jm86b2EUKGw4fY43rukMs2srPPL7_tbY" alt="Admin">
          <div class="overflow-hidden">
            <p class="text-white text-[10px] font-black uppercase tracking-widest truncate">Admin User</p>
            <p class="text-blue-400 text-[8px] font-bold uppercase tracking-widest truncate mt-1">Super Admin</p>
          </div>
        </div>
      </div>
    </aside>

    <!-- Main Content -->
    <div class="flex-1 ml-64 flex flex-col min-h-screen">
      <!-- Header -->
      <header class="sticky top-0 w-full border-b border-slate-100 bg-white/80 backdrop-blur-md flex justify-between items-center px-10 py-5 z-40">
        <div class="flex items-center gap-10 flex-1">
          <h2 class="text-sm font-black text-blue-950 uppercase tracking-[0.2em] whitespace-nowrap">{{ pageTitle }}</h2>
          <div class="relative w-full max-w-md group">
            <span class="material-symbols-outlined absolute left-4 top-1/2 -translate-y-1/2 text-slate-300 group-focus-within:text-blue-950 transition-colors text-sm">search</span>
            <input class="w-full bg-slate-50 border-none rounded-2xl pl-12 pr-4 py-3 text-xs focus:ring-4 focus:ring-blue-100 transition-all outline-none text-blue-950 placeholder:text-slate-300 font-bold" placeholder="Tìm kiếm dữ liệu, đơn hàng..." type="text"/>
          </div>
        </div>

        <div class="flex items-center gap-6">
          <button class="hover:bg-slate-50 rounded-2xl p-3 transition-all relative group">
            <span class="material-symbols-outlined text-slate-400 group-hover:text-blue-950 transition-colors">notifications</span>
            <span class="absolute top-3 right-3 w-2 h-2 bg-red-500 rounded-full border-2 border-white shadow-sm"></span>
          </button>
          <div class="h-6 w-[1px] bg-slate-100"></div>
          <button class="flex items-center gap-3 px-4 py-2 hover:bg-slate-50 rounded-2xl transition-all group">
             <div class="text-right hidden sm:block">
              <p class="text-[10px] font-black text-blue-950 uppercase tracking-widest">Admin User</p>
              <p class="text-[8px] font-bold text-slate-400 uppercase tracking-widest mt-1">Quản trị viên</p>
            </div>
            <span class="material-symbols-outlined text-slate-300 group-hover:text-blue-950 transition-colors">keyboard_arrow_down</span>
          </button>
        </div>
      </header>

      <!-- Content Canvas -->
      <main class="p-10 flex-1">
        <slot></slot>
      </main>

      <!-- Footer -->
      <footer class="p-10 border-t border-slate-50 text-center text-slate-300 text-[10px] font-black uppercase tracking-[0.2em]">
        © 2024 LUXE-TECH Enterprise. All rights reserved.
      </footer>
    </div>
  </div>
</template>
