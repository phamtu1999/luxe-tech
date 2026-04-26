<script setup lang="ts">
import { ref } from 'vue'

const recentOrders = [
  { id: '#LX-7761', date: '15 Tháng 04, 2024', product: 'Sony WH-1000XM5', total: '8,490,000₫', status: 'Đã giao' },
  { id: '#LX-7542', date: '02 Tháng 04, 2024', product: 'iPhone 15 Pro Max', total: '32,990,000₫', status: 'Đã giao' }
]

const wishlist = [
  { name: 'iPad Pro M2', price: '21,490,000₫', image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuCbW1xWdMb452MRsPzSNAxDK-klJwDRSTpb6L2NB9ezvgZm1vAVfxrrMzaKBH-vlm2RuWcgcBZC_LJaVhRGVYfFZWYwqDZ25aOCFuEoerI9x9FVw_hzXMpebUAby-_1AjWxvAqbvAefamEZMPQ3TtlxSPfWeegXhuZg1wfNum7BcgZD_A-htWyuceTVBnyQYnuedMh2LB_7kmrg21A-TRRhw2wf-j7UxQUWTbSqxu8PyQ3DdGlCK97zKZdtZiMaoZzs-quiO5-B3_uE' },
  { name: 'AirPods Max', price: '13,990,000₫', image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuClmC433KXj5d11RUiy7puMqgNfvvFnVZR25y6kQcda_X4ChPWzbmbrjOmEcOw3sP7qMPx3ybFjxWUjQyRankkYPvvLY_kn1-k-7zCHaFgNxvrkr7zASMMv2y8O_SPLIMVnxAiaogQasuHc22yAd_vOVqiG5qF66kI0ckQkedKMX8or0hSMLh1pKh3ozDyOmFy5w0lutJ_D0TPBEdGuxbCVYKlzOftl_J7sKmLd3fORcQIsCVnxQA7gkALKfJI4SHDwfsRD4iVV1nt3' }
]
</script>

<template>
  <div class="flex max-w-7xl mx-auto py-12 px-8 gap-12">
    <!-- Sidebar -->
    <aside class="w-64 flex flex-col gap-8">
      <div class="bg-white p-8 rounded-[2rem] border border-slate-100 shadow-sm flex flex-col items-center text-center">
        <div class="w-20 h-20 rounded-full overflow-hidden border-4 border-slate-50 mb-4 shadow-xl shadow-slate-200/50">
          <img src="https://i.pravatar.cc/150?u=user" class="w-full h-full object-cover">
        </div>
        <h2 class="text-lg font-black text-blue-950">Nguyễn Minh</h2>
        <p class="text-[10px] font-black text-orange-500 uppercase tracking-widest mt-1">Khách hàng VIP</p>
      </div>

      <nav class="bg-white rounded-[2rem] border border-slate-100 shadow-sm overflow-hidden p-4">
        <a v-for="item in [
          { name: 'Bảng điều khiển', icon: 'dashboard', active: true },
          { name: 'Đơn hàng của tôi', icon: 'package_2', active: false },
          { name: 'Sản phẩm yêu thích', icon: 'favorite', active: false },
          { name: 'So sánh sản phẩm', icon: 'compare_arrows', active: false },
          { name: 'Cài đặt tài khoản', icon: 'settings', active: false }
        ]" :key="item.name" href="#" 
          class="flex items-center gap-4 px-6 py-4 rounded-2xl font-black text-[10px] uppercase tracking-widest transition-all"
          :class="item.active ? 'bg-blue-950 text-white shadow-xl shadow-blue-950/20' : 'text-slate-400 hover:bg-slate-50 hover:text-blue-950'">
          <span class="material-symbols-outlined text-sm">{{ item.icon }}</span>
          {{ item.name }}
        </a>
      </nav>

      <button class="flex items-center gap-4 px-10 py-5 text-red-500 font-black text-[10px] uppercase tracking-widest hover:bg-red-50 rounded-2xl transition-all">
        <span class="material-symbols-outlined text-sm">logout</span>
        Đăng xuất
      </button>
    </aside>

    <!-- Main Content -->
    <main class="flex-1">
      <header class="mb-12">
        <h1 class="text-3xl font-black text-blue-950">Chào mừng trở lại, Minh!</h1>
        <p class="text-sm font-bold text-slate-400 mt-2">Hôm nay bạn muốn nâng tầm trải nghiệm công nghệ nào?</p>
      </header>

      <div class="grid grid-cols-1 md:grid-cols-2 gap-8 mb-8">
        <!-- Points Card -->
        <div class="bg-blue-950 p-10 rounded-[3rem] text-white relative overflow-hidden group">
          <div class="relative z-10">
            <div class="flex justify-between items-start mb-10">
              <span class="text-[10px] font-black uppercase tracking-[0.2em] opacity-60">Hạng Thành Viên</span>
              <span class="material-symbols-outlined text-orange-500" style="font-variation-settings: 'FILL' 1">stars</span>
            </div>
            <p class="text-5xl font-black mb-2">12,450</p>
            <p class="text-[10px] font-black uppercase tracking-widest opacity-60">LUXE Points khả dụng</p>
            <button class="mt-10 bg-white text-blue-950 px-8 py-4 rounded-2xl font-black text-[10px] uppercase tracking-widest hover:bg-slate-100 transition-all">Đổi phần thưởng</button>
          </div>
          <div class="absolute -right-16 -bottom-16 w-64 h-64 bg-white/5 rounded-full blur-3xl group-hover:scale-150 transition-transform duration-1000"></div>
        </div>

        <!-- Order Tracking -->
        <div class="bg-white p-10 rounded-[3rem] border border-slate-100 shadow-sm">
          <div class="flex justify-between items-center mb-8">
            <h3 class="text-lg font-black text-blue-950 flex items-center gap-3">
              <span class="material-symbols-outlined text-orange-500">local_shipping</span>
              Đơn hàng đang giao
            </h3>
            <span class="text-[10px] font-black text-orange-500 bg-orange-50 px-3 py-1 rounded-full uppercase tracking-widest">#LX-8892</span>
          </div>
          <div class="flex gap-6 items-center mb-10">
            <div class="w-20 h-20 bg-slate-50 rounded-2xl flex items-center justify-center p-3 border border-slate-100">
              <img src="https://lh3.googleusercontent.com/aida-public/AB6AXuBvI__8DiX6lWm5oGIB6dE1izYam8IF3VfKRcobz9VHcoLE_Jquvr-Tq4_SiP9BM7nKJg6NyXUQFvS4Vw0nc7k1NN8wo5hEK98cGulh7XK7b4whk_aM9Nm4zBL3O197fP-0JPynRzceY_TXVnAE0O_XGHCBy2sPTcwDAmpZgRdckUUyM7MKkW4q-_w6Sm56dm3stk0o7ve-05FLn3dStYqZk2P8a2KGh7bC4_cJumeyqcxcN1NdUP3Q4LxHYfyWzBNk1O55TP0SKT2t" class="w-full h-full object-contain">
            </div>
            <div>
              <p class="text-sm font-black text-blue-950">MacBook Pro M3 Max</p>
              <p class="text-[10px] font-bold text-slate-400 uppercase tracking-widest mt-1">Đã rời kho phân phối tại Hà Nội</p>
            </div>
          </div>
          <div>
            <div class="w-full h-2 bg-slate-50 rounded-full overflow-hidden">
              <div class="w-3/4 h-full bg-orange-500 rounded-full shadow-lg shadow-orange-500/30"></div>
            </div>
            <div class="flex justify-between mt-4">
              <span class="text-[8px] font-black text-slate-300 uppercase tracking-[0.2em]">Xác nhận</span>
              <span class="text-[8px] font-black text-orange-500 uppercase tracking-[0.2em]">Vận chuyển</span>
              <span class="text-[8px] font-black text-slate-300 uppercase tracking-[0.2em]">Đã giao</span>
            </div>
          </div>
        </div>
      </div>

      <div class="grid grid-cols-1 lg:grid-cols-3 gap-8">
        <!-- History -->
        <div class="lg:col-span-2 bg-white p-10 rounded-[3rem] border border-slate-100 shadow-sm">
          <div class="flex justify-between items-center mb-10">
            <h3 class="text-lg font-black text-blue-950 uppercase tracking-tight">Lịch sử đơn hàng</h3>
            <a href="#" class="text-[10px] font-black text-orange-500 uppercase tracking-widest hover:underline">Xem tất cả</a>
          </div>
          <div class="overflow-x-auto">
            <table class="w-full text-left">
              <thead>
                <tr class="text-[10px] font-black text-slate-300 uppercase tracking-widest border-b border-slate-50">
                  <th class="pb-4">Mã đơn</th>
                  <th class="pb-4">Sản phẩm</th>
                  <th class="pb-4 text-right">Tổng cộng</th>
                  <th class="pb-4 text-right">Trạng thái</th>
                </tr>
              </thead>
              <tbody class="divide-y divide-slate-50">
                <tr v-for="o in recentOrders" :key="o.id" class="group">
                  <td class="py-6 text-xs font-black text-blue-950">{{ o.id }}</td>
                  <td class="py-6">
                    <p class="text-xs font-black text-blue-950">{{ o.product }}</p>
                    <p class="text-[8px] font-bold text-slate-400 uppercase tracking-widest">{{ o.date }}</p>
                  </td>
                  <td class="py-6 text-right text-xs font-black text-blue-950">{{ o.total }}</td>
                  <td class="py-6 text-right">
                    <span class="inline-flex items-center gap-1.5 px-3 py-1 rounded-lg bg-green-50 text-green-600 text-[8px] font-black uppercase tracking-widest">
                      <span class="w-1 h-1 rounded-full bg-green-600"></span>
                      {{ o.status }}
                    </span>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>

        <!-- Wishlist -->
        <div class="bg-white p-10 rounded-[3rem] border border-slate-100 shadow-sm">
          <h3 class="text-lg font-black text-blue-950 mb-10 uppercase tracking-tight">Yêu thích</h3>
          <div class="space-y-8">
            <div v-for="p in wishlist" :key="p.name" class="flex gap-4 items-center group cursor-pointer">
              <div class="w-16 h-16 bg-slate-50 rounded-2xl flex items-center justify-center p-2 border border-slate-100 group-hover:border-blue-950 transition-all">
                <img :src="p.image" class="w-full h-full object-contain">
              </div>
              <div class="flex-1 overflow-hidden">
                <p class="text-xs font-black text-blue-950 truncate group-hover:text-blue-700 transition-colors">{{ p.name }}</p>
                <p class="text-[10px] font-bold text-slate-400 uppercase tracking-widest mt-1">{{ p.price }}</p>
              </div>
            </div>
          </div>
          <button class="mt-12 w-full py-4 border-2 border-slate-50 text-blue-950 font-black text-[10px] uppercase tracking-widest rounded-2xl hover:border-blue-950 transition-all">Xem tất cả (8)</button>
        </div>
      </div>
    </main>
  </div>
</template>
