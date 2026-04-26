<script setup lang="ts">
const categories = [
  { name: 'Laptop', icon: 'laptop_mac', path: '/shop' },
  { name: 'Mobile', icon: 'smartphone', path: '/shop' },
  { name: 'Audio', icon: 'headphones', path: '/shop' },
  { name: 'Watch', icon: 'watch', path: '/shop' }
]
</script>

<template>
  <div class="text-blue-950">
    <!-- Hero Section -->
    <section class="relative min-h-screen flex items-center pt-24 overflow-hidden bg-white">
      <div class="absolute top-0 left-0 w-full h-full pointer-events-none">
        <div class="absolute top-[-10%] right-[-10%] w-[60%] h-[60%] bg-blue-50 rounded-full blur-[120px] opacity-50"></div>
        <div class="absolute bottom-[-10%] left-[-10%] w-[50%] h-[50%] bg-orange-50 rounded-full blur-[120px] opacity-30"></div>
      </div>

      <div class="max-w-[1440px] mx-auto px-10 grid lg:grid-cols-2 gap-20 items-center relative z-10">
        <div class="animate-in fade-in slide-in-from-left duration-1000">
          <div class="flex items-center gap-3 mb-8">
            <span class="w-12 h-[2px] bg-orange-500"></span>
            <span class="text-[10px] font-black uppercase tracking-[0.4em] text-orange-500">New Arrival 2024</span>
          </div>
          <h1 class="text-6xl lg:text-8xl font-black uppercase tracking-tighter leading-[0.9] mb-10">
            Titanium.<br/>
            <span class="text-slate-200">Strength.</span><br/>
            Vision.
          </h1>
          <p class="text-slate-400 font-bold text-lg max-w-lg mb-12 leading-relaxed uppercase tracking-tight">
            Thiết kế từ Titanium cấp hàng không vũ trụ. Chip A17 Pro định hình lại hiệu năng smartphone.
          </p>
          <div class="flex gap-8">
            <button class="px-12 py-5 bg-blue-950 text-white font-black text-[10px] uppercase tracking-[0.3em] rounded-2xl shadow-2xl shadow-blue-950/20 hover:scale-105 transition-all active:scale-95">Mua ngay</button>
            <button class="px-12 py-5 border-2 border-slate-100 text-blue-950 font-black text-[10px] uppercase tracking-[0.3em] rounded-2xl hover:bg-slate-50 transition-all active:scale-95">Khám phá</button>
          </div>
        </div>

        <div class="relative flex justify-center animate-in fade-in zoom-in duration-1000 delay-300">
          <img src="https://lh3.googleusercontent.com/aida-public/AB6AXuDcL5BHm3Q7K5whtruEODJHqIZQXeSCWXfJ4MFGckV3vL7_C1P35kpkvty21sD499xCH31C4x3QBT3SvhoKNaU_PM29F_yx796WOpW_iLClbyMnwJAkSOkCLS9jUq_gPhbBOmgKbKlVuTvbKjX7-vDtIJnqV5diCwvPVj_o353xITTzpvzNiwoHW6vKNfjPE04G8egpa0Z0m1pbWJBI7cilR3SNt3u3cCHJLyfG6FmcaS7DRpswiqx9Y-cosbub_p1Rei6q6Lxla7Jo" class="w-full max-w-[550px] drop-shadow-[0_50px_50px_rgba(0,0,0,0.15)] hover:rotate-3 transition-transform duration-700" alt="Hero Image">
        </div>
      </div>

      <div class="absolute bottom-10 left-1/2 -translate-x-1/2 animate-bounce">
        <span class="material-symbols-outlined text-slate-200 text-4xl">expand_more</span>
      </div>
    </section>

    <!-- Bento Grid Showcase -->
    <section class="py-32 bg-slate-50/50">
      <div class="max-w-[1440px] mx-auto px-10">
        <div class="grid grid-cols-1 md:grid-cols-12 gap-8 h-[800px]">
          <!-- Large Feature -->
          <div class="md:col-span-8 bg-white rounded-[3rem] p-16 flex flex-col justify-between relative overflow-hidden group shadow-sm border border-slate-100">
            <div class="relative z-10 max-w-md">
              <span class="text-[10px] font-black text-orange-500 uppercase tracking-[0.3em] mb-4 block">Workstation Series</span>
              <h3 class="text-4xl font-black uppercase tracking-tight mb-6">MacBook Pro M3 Max</h3>
              <p class="text-slate-400 font-bold mb-10 text-sm uppercase leading-relaxed">Sức mạnh không giới hạn cho các tác vụ chuyên nghiệp nặng nhất.</p>
              <button class="bg-blue-950 text-white px-10 py-4 font-black text-[10px] uppercase tracking-widest rounded-xl hover:shadow-xl transition-all">Tìm hiểu thêm</button>
            </div>
            <img src="https://lh3.googleusercontent.com/aida-public/AB6AXuAmsSawMAtPh56xFGvS5GbAp2aE40AmLGPrAjqszwwOVm7ncv7XJiyP3xixrknuFeQVQqAZbal6saJibzDL9m89Ds6wFIbOSSHZEtSMVKutN4TD-iJW5wqqmId469MeIYwEf52xEqYV0_Vft_9qGpxgHptzypRXcw4307MDtusQ7F-zEeBRuzT9VhapGgySOLdW4OS-ZEd35E-RAt_2Y4X_xU2zRSd4Vhq7ywxEXr54qvOkpJotQIq3P2aFTQTWET597AA0zWuQG7Dq" class="absolute right-[-10%] bottom-[-5%] w-[70%] object-contain group-hover:scale-105 transition-transform duration-1000">
          </div>

          <!-- Small Top -->
          <div class="md:col-span-4 bg-blue-950 rounded-[3rem] p-12 text-white flex flex-col items-center justify-center text-center group shadow-2xl shadow-blue-950/20 overflow-hidden relative">
            <div class="relative z-10">
              <span class="material-symbols-outlined text-5xl mb-6 text-orange-500">bolt</span>
              <h4 class="text-2xl font-black uppercase tracking-tight mb-4">Express Delivery</h4>
              <p class="text-blue-300 font-bold text-[10px] uppercase tracking-widest leading-relaxed">Nhận hàng trong 2h<br/>Miễn phí toàn quốc</p>
            </div>
            <div class="absolute inset-0 bg-gradient-to-br from-blue-900 to-transparent opacity-50"></div>
          </div>

          <!-- Small Bottom Left -->
          <div class="md:col-span-4 bg-orange-500 rounded-[3rem] p-12 text-white group overflow-hidden shadow-2xl shadow-orange-500/20">
            <h4 class="text-2xl font-black uppercase tracking-tight mb-4">Premium Audio</h4>
            <p class="text-orange-100 font-bold text-[10px] uppercase tracking-widest mb-10">Âm thanh trung thực tuyệt đối.</p>
            <img src="https://lh3.googleusercontent.com/aida-public/AB6AXuD_dH9T64hkYMLes56TeozKHO1FzccTxYU8CI4X33AekIx1CLMLiH2w6kN0slcj3vziulyZjPEm8C4EJd2McSQagliQBmsECYLpB4rwkR49Gr-VLb-Y3UZXuiKHGTts92s8-LDJPJNbZewHhzzb5-CSFqe66WMW8nSctx12DSRFvWrEqL1Hii6otsdUvAptCaFNI5Vb_iK3JOCI4q8nMRqvpiuu2JoEnYuoz5V9cZS7LqWVukdVSlrQupNAMBct--4T7aT1mIpP5VJu" class="w-full object-contain group-hover:scale-110 transition-transform duration-700">
          </div>

          <!-- Medium Bottom Right -->
          <div class="md:col-span-8 bg-slate-100 rounded-[3rem] p-16 flex items-center gap-12 group overflow-hidden shadow-sm border border-slate-50">
            <div class="flex-grow">
              <h4 class="text-3xl font-black uppercase tracking-tight mb-4 text-blue-950">Next Gen Gaming</h4>
              <p class="text-slate-400 font-bold text-[10px] uppercase tracking-widest leading-relaxed mb-8">Trải nghiệm đồ họa sống động<br/>với GPU mới nhất.</p>
              <button class="text-blue-950 font-black text-[10px] uppercase tracking-[0.2em] flex items-center gap-4 hover:gap-6 transition-all">
                Khám phá Console <span class="material-symbols-outlined">trending_flat</span>
              </button>
            </div>
            <img src="https://lh3.googleusercontent.com/aida-public/AB6AXuCWj0BDq7WQUQwY-1Fng9iA16iQwRENzvn8R7Z5DqXIvFGyqrs4U0l0L9PC3_8GDwuxJSiXaRk7rIJx6KOCYC66GXVBYb1QJhz-DWR-w_GQN5TB5kHYWbDFRHakc2MXrFoi-9lzIG84Kori_pGwKn0XZa8ULp5w80edFEK2UYiJ2gMUje7w7K5WCAfKTgK8wjBRzDaFIqxDEfH0Rp7C4tDL2SyxdgR006TJZ--uM6vI66E9SdtwwdMzrmAg6Y9A8WOSMTQpFGovjLEJ" class="w-[40%] object-contain group-hover:rotate-6 transition-transform duration-700">
          </div>
        </div>
      </div>
    </section>

    <!-- Brands / Stats -->
    <section class="py-32 bg-white">
      <div class="max-w-[1440px] mx-auto px-10 flex flex-wrap justify-center gap-20">
        <div v-for="stat in [
          { val: '2.5M+', label: 'Active Users' },
          { val: '120+', label: 'Flagship Stores' },
          { val: '98%', label: 'Trust Rate' },
          { val: '24/7', label: 'Concierge' }
        ]" :key="stat.label" class="text-center group">
          <p class="text-5xl font-black text-blue-950 mb-3 group-hover:text-orange-500 transition-colors">{{ stat.val }}</p>
          <p class="text-[9px] font-black text-slate-300 uppercase tracking-[0.3em]">{{ stat.label }}</p>
        </div>
      </div>
    </section>
  </div>
</template>
