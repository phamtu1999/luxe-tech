<script setup lang="ts">
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const email = ref('')
const password = ref('')

const handleLogin = () => {
  // Mock login
  if (email.value === 'admin@luxe.tech') {
    router.push('/admin')
  } else {
    router.push('/')
  }
}
</script>

<template>
  <div class="bg-gradient-mesh min-h-screen flex items-center justify-center font-inter text-blue-950 p-6 relative overflow-hidden">
    <!-- Decorative Text in Background -->
    <div class="absolute top-20 left-10 pointer-events-none opacity-5 rotate-90 origin-left">
      <span class="text-[120px] font-black tracking-tighter uppercase">Excellence</span>
    </div>
    <div class="absolute bottom-20 right-10 pointer-events-none opacity-5">
      <span class="text-[120px] font-black tracking-tighter uppercase">Precision</span>
    </div>

    <!-- Login Centered Card -->
    <main class="w-full max-w-[480px] bg-white/80 backdrop-blur-2xl rounded-[3rem] shadow-2xl border border-white/50 overflow-hidden relative z-10 animate-in fade-in zoom-in duration-700">
      <div class="p-12 md:p-16 flex flex-col items-center">
        <!-- Logo Section -->
        <div class="mb-12">
          <RouterLink to="/" class="text-2xl font-black tracking-tighter text-blue-950 hover:opacity-70 transition-opacity">LUXE-TECH</RouterLink>
        </div>

        <!-- Header Text -->
        <div class="text-center mb-12">
          <h1 class="text-2xl font-black uppercase tracking-tight mb-3">Chào mừng trở lại</h1>
          <p class="text-[10px] font-black text-slate-400 uppercase tracking-[0.2em]">Đăng nhập để trải nghiệm công nghệ cao cấp</p>
        </div>

        <!-- Login Form -->
        <form @submit.prevent="handleLogin" class="w-full space-y-10">
          <div class="space-y-4">
            <label class="block text-[9px] font-black text-slate-400 uppercase tracking-[0.2em] ml-4" for="email">Email Access</label>
            <div class="relative group">
              <span class="absolute left-6 top-1/2 -translate-y-1/2 material-symbols-outlined text-slate-300 group-focus-within:text-blue-950 transition-colors">alternate_email</span>
              <input 
                v-model="email"
                class="w-full bg-slate-50 border-none rounded-2xl px-16 py-5 font-bold text-xs text-blue-950 focus:ring-4 focus:ring-blue-100 transition-all placeholder:text-slate-300" 
                id="email" 
                placeholder="name@luxe.tech" 
                type="email"
                required
              />
            </div>
          </div>

          <div class="space-y-4">
            <div class="flex justify-between items-center ml-4 mr-4">
              <label class="block text-[9px] font-black text-slate-400 uppercase tracking-[0.2em]" for="password">Password</label>
              <a class="text-[8px] font-black text-blue-950 hover:underline uppercase tracking-widest transition-all" href="#">Quên mật khẩu?</a>
            </div>
            <div class="relative group">
              <span class="absolute left-6 top-1/2 -translate-y-1/2 material-symbols-outlined text-slate-300 group-focus-within:text-blue-950 transition-colors">lock</span>
              <input 
                v-model="password"
                class="w-full bg-slate-50 border-none rounded-2xl px-16 py-5 font-bold text-xs text-blue-950 focus:ring-4 focus:ring-blue-100 transition-all placeholder:text-slate-300" 
                id="password" 
                placeholder="••••••••" 
                type="password"
                required
              />
            </div>
          </div>

          <button class="w-full py-6 bg-blue-950 text-white font-black text-[10px] uppercase tracking-[0.3em] rounded-2xl shadow-2xl shadow-blue-950/30 hover:bg-blue-900 active:scale-[0.98] transition-all duration-300" type="submit">
            Khởi động hệ thống
          </button>
        </form>

        <!-- Divider -->
        <div class="w-full flex items-center my-12 gap-6">
          <div class="h-[1px] bg-slate-100 flex-grow"></div>
          <span class="text-[8px] font-black text-slate-300 uppercase tracking-[0.2em]">Xác thực nhanh</span>
          <div class="h-[1px] bg-slate-100 flex-grow"></div>
        </div>

        <!-- Social Logins -->
        <div class="w-full grid grid-cols-2 gap-6">
          <button type="button" class="flex items-center justify-center gap-4 py-4 border-2 border-slate-50 rounded-2xl hover:bg-slate-50 active:scale-95 transition-all group">
            <svg class="w-5 h-5 group-hover:scale-110 transition-transform" viewBox="0 0 24 24">
              <path d="M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92c-.26 1.37-1.04 2.53-2.21 3.31v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.09z" fill="#4285F4"></path>
              <path d="M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23z" fill="#34A853"></path>
              <path d="M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18C1.43 8.55 1 10.22 1 12s.43 3.45 1.18 4.93l3.66-2.84z" fill="#FBBC05"></path>
              <path d="M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 6.14-4.53z" fill="#EA4335"></path>
            </svg>
            <span class="text-[9px] font-black uppercase tracking-widest">Google</span>
          </button>
          <button type="button" class="flex items-center justify-center gap-4 py-4 border-2 border-slate-50 rounded-2xl hover:bg-slate-50 active:scale-95 transition-all group">
            <svg class="w-5 h-5 group-hover:scale-110 transition-transform" fill="currentColor" viewBox="0 0 24 24">
              <path d="M17.05 20.28c-.98.95-2.05 1.72-3.32 1.72-1.22 0-1.61-.74-3.08-.74-1.47 0-1.91.72-3.08.74-1.21.02-2.31-.83-3.26-1.78C2.33 18.25 1 15.34 1 12.3c0-4.63 3.12-7.09 6.04-7.09 1.5 0 2.66.92 3.61.92.93 0 2.23-.97 3.86-.97 1.4 0 3.2.53 4.4 2.14-2.82 1.57-2.35 5.51.44 6.78-.96 2.4-2.28 4.95-3.3 6.3zM13.51 3.51c-.13-1.93 1.56-3.51 3.33-3.51.13 1.93-1.57 3.51-3.33 3.51z"></path>
            </svg>
            <span class="text-[9px] font-black uppercase tracking-widest">Apple</span>
          </button>
        </div>

        <!-- Footer Link -->
        <p class="mt-12 text-[10px] font-black text-slate-400 uppercase tracking-widest">
          Chưa có tài khoản? 
          <a class="text-blue-950 underline underline-offset-4 ml-2 hover:text-orange-500 transition-colors" href="#">Khám phá đặc quyền</a>
        </p>
      </div>
    </main>

    <!-- Minimalistic Footer -->
    <footer class="fixed bottom-0 w-full py-8 px-12 flex flex-col md:flex-row justify-between items-center gap-4">
      <div class="text-[8px] font-black text-white/30 uppercase tracking-[0.3em]">© 2024 LUXE-TECH CORPORATE. ALL RIGHTS RESERVED.</div>
      <div class="flex gap-10">
        <a class="text-[8px] font-black text-white/30 hover:text-white transition-colors uppercase tracking-[0.3em]" href="#">Privacy Policy</a>
        <a class="text-[8px] font-black text-white/30 hover:text-white transition-colors uppercase tracking-[0.3em]" href="#">Terms of Service</a>
      </div>
    </footer>
  </div>
</template>

<style>
.bg-gradient-mesh {
  background: radial-gradient(at 0% 0%, #001e40 0%, transparent 50%),
              radial-gradient(at 100% 0%, #1f477b 0%, transparent 50%),
              radial-gradient(at 100% 100%, #001b3c 0%, transparent 50%),
              radial-gradient(at 0% 100%, #3a5f94 0%, transparent 50%);
  background-color: #fcf9f8;
}
</style>
