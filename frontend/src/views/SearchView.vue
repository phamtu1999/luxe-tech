<script setup lang="ts">
import { ref } from 'vue'

const searchQuery = ref('MacBook Pro M3 Max 64GB')
const hasResults = ref(false)

const recommendations = [
  { name: 'MacBook Pro 14" M3', category: 'Laptops', price: '39.990.000₫', status: 'Còn hàng', hot: true, image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuCb2B5YYqiJmOc85PdI0I4x1Xfjiz5YRb_erChGyQwDpWKn4APigKT9GaaCowl0YMk6Te85QjwmObIZo1EGEV_ZZl4AZlPwc9kVJrWdiQRpI7MaRB-Xofrkdg-Ie3sbtUUEZBMd_pzJ2b-PYjzrIglgh2yXX4oNZH4HNRodVK7dPVPN_j6UgI_TVvn9DY4xmZF-_mhpt3W6g0Gs5zt3LohQI5_lw7Nz0aeyZ7D-hrv78Vw0b6Cb-is1DEt5LEJzj-DFaI0aHyDUsNsM' },
  { name: 'iPhone 15 Pro Max 256GB', category: 'Smartphones', price: '29.490.000₫', status: 'Còn hàng', hot: false, image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuDUY6cNChYYVTCdbBhBuK210yl9wrjI55zHtAgFSTU3ulFggqmBSttcZnTGDCmCkmLU1nIdme9h30-Mb5swwdSnh317nzQ7UyFQ6xwL5DtdZ9mxj6J6U-NlBmmvZCi3L-hnBkIZC9UUgv5YeyQVWBCZIZZhyTiTroSn0kjGK3Zd4wGZH42qzHB2YKSZ9SKoCXiISS3nU0Hi8IBvo1iRA_wfmxo2ijt9res6DbR67ikwItGE0TvR-AxBOpnZUwrIY7-WZEk_7UnhdDh_' },
  { name: 'Sony WH-1000XM5', category: 'Audio', price: '6.990.000₫', status: 'Còn hàng', hot: false, image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuANtb-9N2RkKAY2psjZgb0IUjkS7b0pb0rWsECmjRGLkYrpW3SSh_ZYUYLgCLdVzt_koXgVJkxyLBfUafnzjEEJgvLXT41Yc7CGoJIUVBR7216f-LX3JFcJWyR3Sb6vhdBwQo9gSEsi7MTZRW0n_XTGCeOc5r0jJb0OcjdJjm0wvOXn-5AdId-X3APVImHwzc98xSpfueR9ZSU74qzrTz-Q8wbhZfRrHlRarMpZjdNuZ_24sI3S3VuMRi6TNzLxNbDKMSEswA0-aJV2' },
  { name: 'Sony Alpha A7 IV', category: 'Cameras', price: '54.990.000₫', status: 'Còn hàng', hot: false, image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuC3CHyFPjV--4W1vZhn6zwGX1DeMW8hTGhxZzgnz6uJbjYLwAZpQSh4IoaLcxHiTM4fCXhsYuXtR4OO5KD_b2bo7pQdH8bTjFa6D9MokAC9oDDM5GjImh984_JJnW7EWVGQM0uLAV7WBbcwVbP6pKZCUSZZL4T2lH3O6kntcUGQHGtVtUF_GshJAgWDno3gUPcD2Sxsk0C1Wp65RgevUR7bHmodx-lx0pCZ3RKCgQ2eIwMKSya33UISsPnjsmj2G5KFBiLBTql9VFl1' }
]
</script>

<template>
  <div class="max-w-7xl mx-auto px-8 py-16">
    <!-- Search Bar -->
    <div class="max-w-3xl mx-auto mb-24">
      <div class="flex items-center bg-white border-2 border-slate-50 rounded-3xl overflow-hidden shadow-2xl shadow-slate-200/50 focus-within:border-blue-900 transition-all p-2">
        <span class="material-symbols-outlined ml-4 text-slate-400">search</span>
        <input v-model="searchQuery" class="flex-1 py-4 px-6 border-none focus:ring-0 font-bold text-blue-950 placeholder-slate-300" placeholder="Tìm kiếm sản phẩm đẳng cấp...">
        <button class="bg-blue-950 text-white px-10 py-4 rounded-2xl font-black uppercase tracking-widest text-sm hover:bg-blue-900 transition-all">Tìm kiếm</button>
      </div>
      <div class="mt-6 flex flex-wrap justify-center gap-4">
        <span class="text-[10px] font-black text-slate-300 uppercase tracking-widest">Gợi ý:</span>
        <a v-for="tag in ['iPhone 15 Pro', 'Sony WH-1000XM5', 'iPad Pro M4']" :key="tag" href="#" class="text-[10px] font-black text-blue-900 uppercase tracking-widest hover:underline">{{ tag }}</a>
      </div>
    </div>

    <!-- Empty State -->
    <div v-if="!hasResults" class="text-center py-16">
      <div class="mb-10 inline-flex items-center justify-center w-32 h-32 bg-slate-50 rounded-full border border-slate-100">
        <span class="material-symbols-outlined text-slate-200 !text-6xl">search_off</span>
      </div>
      <h1 class="text-3xl font-black text-blue-950 mb-4">Rất tiếc, không tìm thấy sản phẩm</h1>
      <p class="text-slate-400 font-bold max-w-lg mx-auto leading-relaxed mb-12">
        Chúng tôi không tìm thấy kết quả cho <span class="text-blue-950">"{{ searchQuery }}"</span>. Hãy thử kiểm tra lại từ khóa hoặc khám phá các gợi ý bên dưới.
      </p>
      <div class="flex justify-center gap-4">
        <router-link to="/" class="px-8 py-4 bg-blue-950 text-white font-black rounded-2xl hover:bg-blue-900 transition-all text-xs uppercase tracking-widest shadow-lg shadow-blue-900/20">Về trang chủ</router-link>
        <button class="px-8 py-4 border-2 border-slate-100 text-blue-950 font-black rounded-2xl hover:border-blue-950 transition-all text-xs uppercase tracking-widest">Liên hệ tư vấn</button>
      </div>
    </div>

    <!-- Recommendations -->
    <section class="mt-32">
      <div class="flex justify-between items-end mb-12">
        <div>
          <h2 class="text-2xl font-black text-blue-950">Sản phẩm gợi ý</h2>
          <p class="text-sm font-bold text-slate-400 mt-2">Dựa trên xu hướng mua sắm tại LUXE-TECH.</p>
        </div>
        <a href="#" class="text-[10px] font-black text-orange-500 uppercase tracking-[0.2em] flex items-center gap-2 group">
          Xem tất cả <span class="material-symbols-outlined text-sm group-hover:translate-x-1 transition-transform">arrow_forward</span>
        </a>
      </div>

      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-8">
        <div v-for="p in recommendations" :key="p.name" class="group bg-white border border-slate-100 rounded-[2rem] overflow-hidden hover:shadow-2xl hover:shadow-slate-200/50 transition-all duration-500">
          <div class="relative aspect-square overflow-hidden bg-slate-50">
            <img :src="p.image" class="w-full h-full object-contain group-hover:scale-110 transition-transform duration-700">
            <span v-if="p.hot" class="absolute top-6 left-6 bg-orange-500 text-white px-3 py-1 text-[8px] font-black tracking-widest uppercase rounded-lg">Bán chạy</span>
          </div>
          <div class="p-8">
            <p class="text-[10px] font-black text-slate-300 uppercase tracking-widest mb-2">{{ p.category }}</p>
            <h3 class="text-sm font-black text-blue-950 group-hover:text-blue-700 transition-colors truncate">{{ p.name }}</h3>
            <div class="flex items-center justify-between mt-6">
              <span class="text-lg font-black text-blue-950">{{ p.price }}</span>
              <div class="flex items-center gap-2 text-green-600">
                <span class="w-1.5 h-1.5 bg-current rounded-full"></span>
                <span class="text-[10px] font-black uppercase tracking-widest">{{ p.status }}</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Newsletter -->
    <section class="mt-32 bg-blue-950 rounded-[3rem] p-16 relative overflow-hidden">
      <div class="absolute top-0 right-0 w-64 h-64 bg-blue-900/20 blur-3xl -mr-32 -mt-32 rounded-full"></div>
      <div class="relative z-10 flex flex-col lg:flex-row items-center justify-between gap-12">
        <div class="max-w-md text-center lg:text-left">
          <h2 class="text-3xl font-black text-white mb-4">Ưu đãi dành cho bạn</h2>
          <p class="text-blue-200 font-bold leading-relaxed">Đăng ký nhận bản tin để không bỏ lỡ các sản phẩm Limited và ưu đãi độc quyền dành riêng cho khách hàng VIP.</p>
        </div>
        <div class="flex w-full lg:w-auto gap-4">
          <input class="flex-1 lg:w-96 rounded-2xl border-none py-5 px-8 text-sm font-bold text-blue-950 placeholder-blue-300" placeholder="Nhập email của bạn...">
          <button class="bg-orange-500 text-white px-10 py-5 font-black rounded-2xl hover:bg-orange-600 transition-all text-xs uppercase tracking-widest shadow-xl shadow-orange-500/20">Đăng ký</button>
        </div>
      </div>
    </section>
  </div>
</template>
