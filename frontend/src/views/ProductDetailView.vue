<script setup lang="ts">
import { ref } from 'vue'

const currentImage = ref('https://lh3.googleusercontent.com/aida-public/AB6AXuBU1hud_FT9Pfoe-lJrLD-qimTq52JBSXLHEdJtKQ9CZx1P1Epwjf8Yn8njJvTReRiQc6FnmdRwJiH7V0mibz9xojJNVz4b0eG9bQXDKz7UQYTEjeN_edW01trI9jClkIbRh3TE99QVKz9-CCvr7lq-AAQi9iax26tX0WcpBOWbTsQDU5kAsew8puYwzPlDg47aNwX_Mn7HqDKsvp360Wxu8zvcf7nfOHtg5rp4WjlJAS5gKlGEM0xB5-qU1gBBRKwd2yoEizU_9V9K')

const gallery = [
  'https://lh3.googleusercontent.com/aida-public/AB6AXuBU1hud_FT9Pfoe-lJrLD-qimTq52JBSXLHEdJtKQ9CZx1P1Epwjf8Yn8njJvTReRiQc6FnmdRwJiH7V0mibz9xojJNVz4b0eG9bQXDKz7UQYTEjeN_edW01trI9jClkIbRh3TE99QVKz9-CCvr7lq-AAQi9iax26tX0WcpBOWbTsQDU5kAsew8puYwzPlDg47aNwX_Mn7HqDKsvp360Wxu8zvcf7nfOHtg5rp4WjlJAS5gKlGEM0xB5-qU1gBBRKwd2yoEizU_9V9K',
  'https://lh3.googleusercontent.com/aida-public/AB6AXuCbb_cZ1_H3HACU8rJfaQtbBdGjxHmT-QEPKIffh49IPmzPvH77sgKYRYp0nVQPm8RN41ehioJhyEsuKJwuPU6mfIDL2Su5jGgpDPt_k-EI-US_HVw-vjsjoxccPVKiFsJcdAtP6lFWCTY7pzQVTnoVQbG7vDQ4JRd-5KNgIyJVPW6lzmNiKhOE2f-NA3NF0fpoHDegiuOeZxjpnSEXQ2n-U4TWPb9GmhuI5tZBYYhyEFd25rq4jH68ge0u5EM1Z40cxyBj6vL-WyNo',
  'https://lh3.googleusercontent.com/aida-public/AB6AXuD7hNo5teOGmEfk7tBIC0b1oFQjYbWG6oKb3yZ7TJx7eChSAX8nlZpy-JMn82Lbk3_GMhHg11X59HrR58WxjDQYz8GWoUzH1-rfnvUIHUtgJ5uhr97yj2TdFH76mFf-tuPSylNaDzaueaWSxMkjpjrh3m0kZwUtrCcKpGTvQbcdYYU5_I8ytL4_hrYXiOVOC3ypVdKYBQN431yHRzaDFGQm7Jetht8BJECL1PgQ7qu2AS0FVlk8FGoOtWflTY3uLwRjqJkIOVnnxbKi',
  'https://lh3.googleusercontent.com/aida-public/AB6AXuCsHHe3lhUkdc1M5p02sTXSEt4pUJZCMiUAMmjlDBsCxm039oC4PTEsDqE0KV1xdrjAW2r0c4echWsVRb3CMy5H8-sJWbVJmDnMuqp8yXotFpWSeH6GwUZcVEP4JLBQEhZX_BH6QvLpYtJ8tX4AEE_tXsZ4Ws04SuDC4SVViPV8PFxmjyXx_SjYHNsZE6o280Jux-QfJGRQV7TYyRgXvOD8u9G8YjydYBj_CxF5TLsFRni1IQH27PorU-VwcRfxhT2DgeW2_A6Q7PLq'
]

const specs = [
  { label: 'Display', value: '6.7" Super Retina XDR OLED' },
  { label: 'Chipset', value: 'A18 Pro with 6-core GPU' },
  { label: 'Camera', value: '48MP Pro System with 5x Telephoto' },
  { label: 'Battery', value: 'Up to 29 hours video playback' },
  { label: 'Safety', value: 'Crash Detection & Satellite SOS' }
]
</script>

<template>
  <div class="pt-32 pb-32 max-w-[1440px] mx-auto px-10">
    <!-- Breadcrumbs -->
    <nav class="flex items-center gap-3 mb-12 text-[10px] font-black uppercase tracking-[0.2em] text-slate-400">
      <RouterLink to="/" class="hover:text-blue-950 transition-colors">Trang chủ</RouterLink>
      <span class="material-symbols-outlined text-sm">chevron_right</span>
      <RouterLink to="/shop" class="hover:text-blue-950 transition-colors">Smartphones</RouterLink>
      <span class="material-symbols-outlined text-sm">chevron_right</span>
      <span class="text-blue-950">Zenith Phone Pro Max</span>
    </nav>

    <div class="grid grid-cols-1 lg:grid-cols-12 gap-16">
      <!-- Gallery -->
      <div class="lg:col-span-7">
        <div class="flex flex-col md:flex-row gap-8">
          <div class="flex md:flex-col gap-4 order-2 md:order-1 overflow-x-auto md:overflow-y-auto max-h-[600px] custom-scrollbar pr-2">
            <button 
              v-for="img in gallery" 
              :key="img"
              @click="currentImage = img"
              class="flex-shrink-0 w-24 h-24 rounded-2xl border-2 transition-all p-2 bg-white overflow-hidden"
              :class="currentImage === img ? 'border-blue-950 shadow-xl' : 'border-slate-50 hover:border-blue-200'"
            >
              <img :src="img" class="w-full h-full object-contain">
            </button>
          </div>
          <div class="flex-1 order-1 md:order-2 relative group rounded-[3rem] overflow-hidden bg-white border border-slate-50 shadow-2xl shadow-slate-200/50">
            <img :src="currentImage" class="w-full h-[650px] object-contain transition-transform duration-700 group-hover:scale-110 cursor-zoom-in">
            <div class="absolute top-8 right-8">
              <button class="w-12 h-12 bg-white/80 backdrop-blur-xl rounded-full shadow-lg flex items-center justify-center hover:bg-white transition-all group">
                <span class="material-symbols-outlined text-blue-950 group-hover:scale-110 transition-transform">favorite</span>
              </button>
            </div>
          </div>
        </div>
      </div>

      <!-- Info -->
      <div class="lg:col-span-5 flex flex-col justify-center">
        <div class="mb-10">
          <span class="bg-blue-950 text-white px-4 py-2 rounded-full text-[9px] font-black uppercase tracking-[0.2em] mb-6 inline-block shadow-lg shadow-blue-950/20">Titanium Series</span>
          <h1 class="text-4xl font-black text-blue-950 uppercase tracking-tight mb-4">Zenith Phone Pro Max</h1>
          <div class="flex items-center gap-6">
            <div class="flex text-orange-500">
              <span v-for="i in 5" :key="i" class="material-symbols-outlined text-lg" style="font-variation-settings: 'FILL' 1">star</span>
            </div>
            <span class="text-[10px] font-black text-slate-400 uppercase tracking-widest">(128 Reviewers)</span>
          </div>
        </div>

        <div class="mb-12">
          <div class="flex items-baseline gap-6 mb-2">
            <p class="text-4xl font-black text-blue-950 tracking-tight">29.990.000₫</p>
            <p class="text-lg font-bold text-slate-300 line-through">32.990.000₫</p>
          </div>
          <p class="text-[9px] font-black text-green-500 uppercase tracking-widest">Tiết kiệm: 3.000.000₫ (10%)</p>
        </div>

        <div class="space-y-10 mb-12">
          <div>
            <p class="text-[10px] font-black text-blue-950 uppercase tracking-widest mb-6">Màu sắc: Titan Tự Nhiên</p>
            <div class="flex gap-4">
              <button class="w-12 h-12 rounded-full border-4 border-white ring-4 ring-blue-950 bg-slate-400 shadow-xl transition-all"></button>
              <button class="w-12 h-12 rounded-full border-4 border-white ring-4 ring-transparent hover:ring-slate-100 bg-slate-800 transition-all"></button>
              <button class="w-12 h-12 rounded-full border-4 border-white ring-4 ring-transparent hover:ring-slate-100 bg-blue-100 transition-all"></button>
            </div>
          </div>

          <div>
            <p class="text-[10px] font-black text-blue-950 uppercase tracking-widest mb-6">Dung lượng</p>
            <div class="flex flex-wrap gap-4">
              <button class="px-10 py-4 bg-blue-950 text-white font-black text-[10px] uppercase tracking-widest rounded-2xl shadow-xl shadow-blue-950/20">256GB</button>
              <button class="px-10 py-4 border-2 border-slate-50 text-slate-400 font-black text-[10px] uppercase tracking-widest rounded-2xl hover:border-blue-950 hover:text-blue-950 transition-all">512GB</button>
              <button class="px-10 py-4 border-2 border-slate-50 text-slate-400 font-black text-[10px] uppercase tracking-widest rounded-2xl hover:border-blue-950 hover:text-blue-950 transition-all">1TB</button>
            </div>
          </div>
        </div>

        <div class="flex flex-col gap-4">
          <button class="w-full py-6 bg-orange-500 text-white font-black text-[11px] uppercase tracking-[0.3em] rounded-[1.5rem] shadow-2xl shadow-orange-500/30 hover:bg-orange-600 active:scale-[0.98] transition-all">
            Mua ngay (Checkout Now)
          </button>
          <div class="grid grid-cols-2 gap-4">
            <button class="py-5 border-2 border-blue-950 text-blue-950 font-black text-[10px] uppercase tracking-[0.2em] rounded-[1.5rem] hover:bg-blue-950 hover:text-white transition-all active:scale-[0.98]">
              Thêm vào giỏ
            </button>
            <button class="py-5 border-2 border-blue-950 text-blue-950 font-black text-[10px] uppercase tracking-[0.2em] rounded-[1.5rem] hover:bg-blue-950 hover:text-white transition-all active:scale-[0.98]">
              Trả góp 0%
            </button>
          </div>
        </div>

        <div class="mt-16 grid grid-cols-3 gap-8 pt-10 border-t border-slate-50">
          <div v-for="item in [
            { icon: 'shield', text: 'Bảo hành\n12 tháng' },
            { icon: 'local_shipping', text: 'Giao hàng\n2h miễn phí' },
            { icon: 'currency_exchange', text: 'Đổi trả\n30 ngày' }
          ]" :key="item.icon" class="flex flex-col items-center text-center group">
            <span class="material-symbols-outlined text-blue-950 text-3xl mb-4 group-hover:scale-110 transition-transform">{{ item.icon }}</span>
            <p class="text-[9px] font-black text-slate-400 uppercase tracking-widest leading-relaxed whitespace-pre-line">{{ item.text }}</p>
          </div>
        </div>
      </div>
    </div>

    <!-- Feature Section -->
    <section class="mt-32">
      <div class="border-b border-slate-50 flex gap-16 mb-20">
        <button class="pb-6 text-sm font-black text-blue-950 border-b-4 border-blue-950 uppercase tracking-[0.2em]">Đặc điểm nổi bật</button>
        <button class="pb-6 text-sm font-black text-slate-300 hover:text-blue-950 transition-colors uppercase tracking-[0.2em]">Thông số kỹ thuật</button>
        <button class="pb-6 text-sm font-black text-slate-300 hover:text-blue-950 transition-colors uppercase tracking-[0.2em]">Đánh giá (128)</button>
      </div>

      <div class="grid grid-cols-1 lg:grid-cols-2 gap-20 items-center">
        <div class="space-y-10">
          <h2 class="text-4xl font-black text-blue-950 uppercase tracking-tight leading-tight">Trải nghiệm thị giác<br/>không giới hạn</h2>
          <p class="text-slate-400 font-bold leading-relaxed text-sm">
            Màn hình Super Retina XDR OLED thế hệ mới với công nghệ ProMotion 120Hz mang lại sự mượt mà tuyệt đối trong mọi thao tác chạm vuốt. Độ sáng tối đa 2000 nits giúp bạn dễ dàng sử dụng ngay cả dưới ánh nắng gắt nhất.
          </p>
          <ul class="space-y-6">
            <li v-for="s in specs" :key="s.label" class="flex items-center gap-6 group">
              <span class="material-symbols-outlined text-blue-950 bg-slate-50 p-3 rounded-xl group-hover:bg-blue-950 group-hover:text-white transition-all duration-500">done</span>
              <div>
                <p class="text-[9px] font-black text-slate-400 uppercase tracking-widest">{{ s.label }}</p>
                <p class="text-xs font-black text-blue-950 uppercase tracking-widest mt-1">{{ s.value }}</p>
              </div>
            </li>
          </ul>
        </div>
        <div class="rounded-[4rem] overflow-hidden shadow-2xl border-8 border-white group">
          <img class="w-full h-full object-cover transition-transform duration-1000 group-hover:scale-110" src="https://lh3.googleusercontent.com/aida-public/AB6AXuDqDemhX1C6L8WVnvofSkozabAtD_bJXCV9qoQ58cNbKSBQR6hLe-dR9-UOGlvneAzjcGyTQFtDGnkjY-ABlLzZps2OEWHJEiA3YwU1J7WTiDLRPGAtOrheHk9Pbx6gSD-uvfUmrbhCG6H8p6TfIIUCmepMwcs1p8DB8NqXfvWtTqBydctxWz63DYQ4iJL0OxRJQJyf769VZqGH6HJgvpPqQ2YRsnmOjp9K4iCrJLIy1X9WVTvOf19_o-p9R4Ool9qNpp6VLpSvKONt" alt="Feature Image">
        </div>
      </div>
    </section>
  </div>
</template>

<style scoped>
.custom-scrollbar::-webkit-scrollbar {
  width: 4px;
}
.custom-scrollbar::-webkit-scrollbar-track {
  background: transparent;
}
.custom-scrollbar::-webkit-scrollbar-thumb {
  background: #f1f5f9;
  border-radius: 10px;
}
</style>
