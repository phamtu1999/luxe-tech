<script setup lang="ts">
import { useRouter } from 'vue-router'

const router = useRouter()

const goHome = () => router.push('/')
const goSupport = () => router.push('/support')
</script>

<template>
  <div class="min-h-screen flex items-center justify-center px-8 relative overflow-hidden bg-slate-50/50">
    <!-- Background Elements -->
    <div class="absolute -top-40 -right-40 w-96 h-96 bg-blue-950/5 rounded-full blur-[120px]"></div>
    <div class="absolute -bottom-40 -left-40 w-[500px] h-[500px] bg-orange-500/5 rounded-full blur-[150px]"></div>

    <div class="max-w-7xl w-full grid grid-cols-1 md:grid-cols-12 items-center gap-16 relative z-10">
      <!-- Content -->
      <div class="md:col-start-2 md:col-span-5 flex flex-col items-center md:items-start text-center md:text-left space-y-10 order-2 md:order-1">
        <div class="inline-flex items-center gap-4">
          <div class="h-0.5 w-16 bg-blue-950"></div>
          <span class="text-blue-950 font-black text-[10px] uppercase tracking-[0.3em]">Lỗi 404</span>
        </div>
        
        <h1 class="text-6xl font-black text-blue-950 leading-[1.1] tracking-tight">
          Ối! Trang này đã biến mất vào <span class="text-orange-500 italic">hố đen</span> kỹ thuật số
        </h1>
        
        <p class="text-lg font-bold text-slate-400 max-w-lg leading-relaxed">
          Hệ thống của LUXE-TECH không thể tìm thấy đường dẫn bạn yêu cầu. Có thể nội dung đã được di chuyển hoặc không còn tồn tại trong kho lưu trữ.
        </p>

        <div class="flex flex-col sm:flex-row gap-6 w-full sm:w-auto pt-6">
          <button @click="goHome" class="bg-blue-950 text-white font-black text-[10px] uppercase tracking-[0.2em] px-10 py-6 rounded-2xl shadow-2xl shadow-blue-950/30 hover:bg-blue-900 active:scale-95 transition-all flex items-center justify-center gap-3">
            Quay lại trang chủ
            <span class="material-symbols-outlined text-sm">arrow_right_alt</span>
          </button>
          <button @click="goSupport" class="border-2 border-slate-100 text-blue-950 font-black text-[10px] uppercase tracking-[0.2em] px-10 py-6 rounded-2xl hover:border-blue-950 hover:bg-white transition-all flex items-center justify-center active:scale-95">
            Trung tâm hỗ trợ
          </button>
        </div>

        <div class="pt-16 flex items-center gap-6 opacity-20 grayscale scale-90 md:scale-100 origin-left">
          <span class="text-2xl font-black tracking-tighter text-blue-950">LUXE ELECTRONICS</span>
          <div class="h-4 w-0.5 bg-blue-950"></div>
          <span class="text-[10px] font-black uppercase tracking-[0.2em]">Quality First</span>
        </div>
      </div>

      <!-- Illustration Area -->
      <div class="md:col-span-5 flex justify-center items-center order-1 md:order-2">
        <div class="relative w-full aspect-square max-w-[500px]">
          <!-- Illustration -->
          <div class="absolute inset-0 flex items-center justify-center transform hover:scale-105 transition-transform duration-700">
            <img src="https://lh3.googleusercontent.com/aida-public/AB6AXuA54pLbBNt_LnUOrqqxwQN3Mjk9sXpJ9MN-t2qR51Ns7tvbxudpn05iRki3SgGuyEP3T7Wmp6AxG71pD3ZEUxFIjP08EXNhyLM4VL-2xaBZ3Sp5zTjl5RhTsO5rWgWDNRNdAWTIsEryYPH472HbWjZqkI6cBB9tby_xnhcTHvuLqn3mrWljqUHxlzYhZnyYgWgE3zwhy1gqvP_xwRLqCVan7iX8RXXz-87yQFxv35ma18F4ORJuya5z5PbYpw4ZwgY0ciPjXl-a0Uii" 
                 class="w-full h-full object-contain mix-blend-multiply opacity-90 drop-shadow-2xl">
          </div>

          <!-- Floating Elements -->
          <div class="absolute top-1/4 -left-4 p-5 bg-white/80 backdrop-blur-xl rounded-3xl border border-white shadow-2xl animate-bounce" style="animation-duration: 3s;">
            <span class="material-symbols-outlined text-blue-950 text-2xl" style="font-variation-settings: 'FILL' 1">settings_ethernet</span>
          </div>
          <div class="absolute bottom-1/4 -right-4 p-5 bg-white/80 backdrop-blur-xl rounded-3xl border border-white shadow-2xl animate-bounce" style="animation-duration: 5s;">
            <span class="material-symbols-outlined text-orange-500 text-2xl" style="font-variation-settings: 'FILL' 1">terminal</span>
          </div>
          
          <!-- Circle Decor -->
          <div class="absolute inset-0 border-[40px] border-white/30 rounded-full scale-110 -z-10 blur-sm"></div>
        </div>
      </div>
    </div>

    <!-- Bottom Link -->
    <div class="absolute bottom-10 right-10 hidden md:block">
      <a href="#" class="group flex items-center gap-4 text-slate-300 hover:text-blue-950 transition-all duration-300">
        <span class="text-[10px] font-black uppercase tracking-widest">Báo cáo sự cố kỹ thuật</span>
        <span class="material-symbols-outlined text-sm group-hover:translate-x-2 transition-transform">bug_report</span>
      </a>
    </div>
  </div>
</template>

<style scoped>
@keyframes bounce {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-20px); }
}
.animate-bounce {
  animation: bounce infinite ease-in-out;
}
</style>
