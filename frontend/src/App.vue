<script setup lang="ts">
import { RouterLink, RouterView, useRoute } from 'vue-router'
import { computed, ref } from 'vue'
import QuickCart from './components/QuickCart.vue'

const route = useRoute()
const isCartOpen = ref(false)
const isMobileMenuOpen = ref(false)

const showShell = computed(() => {
  const hiddenPaths = ['/admin', '/login']
  return !hiddenPaths.some(path => route.path.startsWith(path))
})
</script>

<template>
  <div class="font-inter">
    <QuickCart :is-open="isCartOpen" @close="isCartOpen = false" />
    
    <!-- Header -->
    <header v-if="showShell" class="bg-white/90 backdrop-blur-md text-slate-900 border-b border-slate-100 top-0 z-[60] fixed w-full h-24 flex items-center">
      <div class="flex justify-between items-center px-10 w-full max-w-[1440px] mx-auto">
        <RouterLink to="/" class="text-xl font-black tracking-tighter text-blue-950 hover:opacity-80 transition-opacity">LUXE-TECH</RouterLink>
        
        <nav class="hidden lg:flex gap-12 font-inter text-[10px] font-black uppercase tracking-[0.2em] text-slate-400">
          <RouterLink to="/shop" class="hover:text-blue-950 transition-colors py-2" active-class="text-blue-950 border-b-2 border-blue-950">Shop</RouterLink>
          <RouterLink to="/comparison" class="hover:text-blue-950 transition-colors py-2" active-class="text-blue-950 border-b-2 border-blue-950">Comparison</RouterLink>
          <RouterLink to="/blog" class="hover:text-blue-950 transition-colors py-2" active-class="text-blue-950 border-b-2 border-blue-950">Journal</RouterLink>
          <RouterLink to="/support" class="hover:text-blue-950 transition-colors py-2" active-class="text-blue-950 border-b-2 border-blue-950">Concierge</RouterLink>
        </nav>

        <div class="flex items-center gap-8">
          <div class="hidden md:flex items-center gap-4 bg-slate-50 px-6 py-3 rounded-2xl group focus-within:ring-2 focus-within:ring-blue-100 transition-all">
            <span class="material-symbols-outlined text-sm text-slate-300 group-focus-within:text-blue-950 transition-colors">search</span>
            <input type="text" @focus="$router.push('/search')" class="bg-transparent border-none p-0 text-[10px] font-black uppercase tracking-widest placeholder:text-slate-300 focus:ring-0 w-32 focus:w-48 transition-all" placeholder="Discovery">
          </div>
          
          <div class="flex items-center gap-6">
            <button @click="isCartOpen = true" class="hover:opacity-70 transition-all active:scale-95 relative group">
              <span class="material-symbols-outlined text-slate-400 group-hover:text-blue-950 transition-colors" style="font-variation-settings: 'opsz' 20">shopping_bag</span>
              <span class="absolute -top-1 -right-1 bg-orange-500 text-white text-[8px] font-black w-4 h-4 rounded-full flex items-center justify-center shadow-lg shadow-orange-500/30">2</span>
            </button>
            <RouterLink to="/account" class="hover:opacity-70 transition-all active:scale-95 group">
              <span class="material-symbols-outlined text-slate-400 group-hover:text-blue-950 transition-colors" style="font-variation-settings: 'opsz' 20">person</span>
            </RouterLink>
            <button @click="isMobileMenuOpen = !isMobileMenuOpen" class="lg:hidden hover:opacity-70 transition-all">
              <span class="material-symbols-outlined text-blue-950">{{ isMobileMenuOpen ? 'close' : 'menu' }}</span>
            </button>
          </div>
        </div>
      </div>

      <!-- Mobile Menu Overlay -->
      <div v-if="isMobileMenuOpen" class="fixed inset-0 top-24 bg-white z-[70] p-10 flex flex-col gap-8 lg:hidden animate-in slide-in-from-top duration-300">
        <RouterLink v-for="link in [
          { name: 'Shop All', path: '/shop' },
          { name: 'Compare Devices', path: '/comparison' },
          { name: 'Journal', path: '/blog' },
          { name: 'Support', path: '/support' },
          { name: 'Admin Dashboard', path: '/admin' }
        ]" :key="link.path" :to="link.path" @click="isMobileMenuOpen = false" class="text-2xl font-black text-blue-950 uppercase tracking-tight">{{ link.name }}</RouterLink>
      </div>
    </header>

    <main :class="{ 'pt-20': showShell }" class="flex-grow">
      <RouterView />
    </main>

    <!-- Footer -->
    <footer v-if="showShell" class="bg-white border-t border-slate-100 pt-24 pb-12">
      <div class="max-w-7xl mx-auto px-8 grid grid-cols-1 md:grid-cols-4 gap-12">
        <div class="col-span-1 md:col-span-1">
          <div class="text-2xl font-black tracking-tighter text-blue-900 mb-8">LUXE-TECH</div>
          <p class="text-slate-500 mb-6 italic">© 2024 LUXE-TECH. Tinh hoa công nghệ trong tầm tay.</p>
          <div class="flex space-x-4">
            <a class="w-8 h-8 flex items-center justify-center border border-slate-200 rounded-lg hover:bg-blue-950 hover:text-white transition-all" href="#"><span class="material-symbols-outlined text-sm">social_leaderboard</span></a>
            <a class="w-8 h-8 flex items-center justify-center border border-slate-200 rounded-lg hover:bg-blue-950 hover:text-white transition-all" href="#"><span class="material-symbols-outlined text-sm">alternate_email</span></a>
            <a class="w-8 h-8 flex items-center justify-center border border-slate-200 rounded-lg hover:bg-blue-950 hover:text-white transition-all" href="#"><span class="material-symbols-outlined text-sm">share</span></a>
          </div>
        </div>
        <div>
          <h4 class="text-[10px] font-black text-blue-950 mb-8 uppercase tracking-[0.2em]">Hỗ trợ khách hàng</h4>
          <ul class="space-y-4">
            <li><RouterLink class="text-xs font-bold text-slate-400 hover:text-orange-500 transition-colors uppercase tracking-widest" to="/support">Liên hệ & Hỗ trợ</RouterLink></li>
            <li><RouterLink class="text-xs font-bold text-slate-400 hover:text-orange-500 transition-colors uppercase tracking-widest" to="/comparison">So sánh sản phẩm</RouterLink></li>
            <li><RouterLink class="text-xs font-bold text-slate-400 hover:text-orange-500 transition-colors uppercase tracking-widest" to="/checkout">Thanh toán</RouterLink></li>
            <li><RouterLink class="text-xs font-bold text-slate-400 hover:text-orange-500 transition-colors uppercase tracking-widest" to="/orders">Theo dõi đơn hàng</RouterLink></li>
          </ul>
        </div>
        <div>
          <h4 class="text-[10px] font-black text-blue-950 mb-8 uppercase tracking-[0.2em]">Khám phá</h4>
          <ul class="space-y-4">
            <li><RouterLink class="text-xs font-bold text-slate-400 hover:text-orange-500 transition-colors uppercase tracking-widest" to="/shop">Cửa hàng</RouterLink></li>
            <li><RouterLink class="text-xs font-bold text-slate-400 hover:text-orange-500 transition-colors uppercase tracking-widest" to="/blog">Tin tức công nghệ</RouterLink></li>
            <li><RouterLink class="text-xs font-bold text-slate-400 hover:text-orange-500 transition-colors uppercase tracking-widest" to="/account">Tài khoản của tôi</RouterLink></li>
          </ul>
        </div>
        <div>
          <h4 class="text-[10px] font-black text-blue-950 mb-8 uppercase tracking-[0.2em]">Đăng ký bản tin</h4>
          <p class="text-xs font-bold text-slate-400 mb-6 leading-relaxed">Nhận thông báo về sản phẩm mới và ưu đãi đặc quyền sớm nhất.</p>
          <div class="flex gap-2">
            <input class="bg-slate-50 border-none px-4 py-3 text-xs w-full focus:ring-4 focus:ring-blue-100 transition-all rounded-xl" placeholder="Email của bạn" type="email"/>
            <button class="bg-blue-950 text-white px-6 py-3 rounded-xl transition-all hover:bg-blue-900 active:scale-95"><span class="material-symbols-outlined text-sm">send</span></button>
          </div>
        </div>
      </div>
      <div class="max-w-7xl mx-auto px-8 mt-16 pt-8 border-t border-slate-50 flex flex-col md:flex-row justify-between items-center gap-4 text-[10px] font-black text-slate-300 uppercase tracking-widest">
        <p>© 2024 LUXE-TECH. All rights reserved.</p>
        <div class="flex gap-6">
          <a class="hover:text-blue-950" href="#">Quy định chung</a>
          <a class="hover:text-blue-950" href="#">Chính sách bảo mật</a>
        </div>
      </div>
    </footer>
  </div>
</template>
