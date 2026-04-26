<script setup lang="ts">

defineProps<{
  isOpen: boolean
}>()

const emit = defineEmits(['close'])

const cartItems = [
  { id: 1, name: 'MacBook Pro 14" M3', specs: 'Space Grey / 512GB', price: '$1,999.00', qty: 1, image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBnLRLQ-f4WcRw1ElvkghPIYqSlf3hEwj68eJ9S2d2y4eckZR_KPsbfqdOHUhg5mqQhZ_rR4ydICi6tPpPOvgOX4z_O_rHs4trCOZjscoXPcQzpdH-2QWcKpFOyWgKNvRc5x-pQAfI291GWjHgXSZEojqx9a7b3FpmJKn3g30mzXWPoi1RzIumVCD7etEufrcA69D0DKDnxF76QJ0nhfP39k4fNpA26-HhEiaHSi9XNWla8UfSOB7kC2rdZwBl7InnEJEqMxxVh7AoU' },
  { id: 2, name: 'Sony WH-1000XM5', specs: 'Black / Noise Canceling', price: '$349.00', qty: 1, image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuCp9M3ZZToEsb-mKyCa4uYAkKV140UnR-ewPhTQOk9KyHHcrtXVf5L3ag5ffXV75RImwRPxkbKl52LWPBVSrYHzt63TIcbIPqIDqemoZqCncBP-zLhJBfklTViFSgdvyqNzQEdv_N5X8T0wj_YCCwYgWcebz7q-20dmFOcipkHeMFkfZ79e2nlkyV05lpcUIOiwU350izt7WC6rjlfB5zBsj3WJTAJSTQSb8hY2AYjMoRTuZg3rWCERO8IygBgH5pPfUMsUCFJLy31Q' }
]
</script>

<template>
  <div>
    <!-- Backdrop -->
    <div 
      v-if="isOpen" 
      class="fixed inset-0 bg-blue-950/40 backdrop-blur-md z-[100] transition-opacity duration-500"
      @click="emit('close')"
    ></div>

    <!-- Drawer -->
    <aside 
      class="fixed right-0 top-0 h-full w-full sm:w-[450px] z-[110] bg-white shadow-2xl flex flex-col transform transition-transform duration-500 ease-out border-l border-slate-100"
      :class="isOpen ? 'translate-x-0' : 'translate-x-full'"
    >
      <!-- Header -->
      <div class="flex items-center justify-between p-10 border-b border-slate-50">
        <div>
          <h2 class="text-xl font-black text-blue-950 uppercase tracking-tight">Giỏ hàng của bạn</h2>
          <p class="text-[10px] font-black text-slate-400 uppercase tracking-widest mt-1">2 thiết bị trong giỏ</p>
        </div>
        <button 
          class="w-10 h-10 rounded-full hover:bg-slate-50 flex items-center justify-center transition-all group"
          @click="emit('close')"
        >
          <span class="material-symbols-outlined text-slate-300 group-hover:text-blue-950">close</span>
        </button>
      </div>

      <!-- Items List -->
      <div class="flex-grow overflow-y-auto p-10 space-y-10 custom-scrollbar">
        <div v-for="item in cartItems" :key="item.id" class="flex gap-6 group">
          <div class="w-24 h-24 bg-slate-50 rounded-[1.5rem] p-3 flex items-center justify-center border border-slate-100 group-hover:scale-105 transition-transform duration-500">
            <img :src="item.image" class="w-full h-full object-contain" alt="Product">
          </div>
          <div class="flex-grow">
            <div class="flex justify-between items-start mb-2">
              <h4 class="text-xs font-black text-blue-950 uppercase tracking-widest leading-relaxed">{{ item.name }}</h4>
              <button class="text-slate-200 hover:text-red-500 transition-colors">
                <span class="material-symbols-outlined text-lg">delete</span>
              </button>
            </div>
            <p class="text-[9px] font-bold text-slate-400 uppercase tracking-widest mb-4">{{ item.specs }}</p>
            <div class="flex items-center justify-between">
              <div class="flex items-center bg-slate-50 rounded-xl px-2">
                <button class="p-2 text-slate-300 hover:text-blue-950"><span class="material-symbols-outlined text-xs">remove</span></button>
                <span class="px-4 text-[10px] font-black text-blue-950">{{ item.qty }}</span>
                <button class="p-2 text-slate-300 hover:text-blue-950"><span class="material-symbols-outlined text-xs">add</span></button>
              </div>
              <span class="text-xs font-black text-blue-950">{{ item.price }}</span>
            </div>
          </div>
        </div>
      </div>

      <!-- Footer -->
      <div class="p-10 border-t border-slate-50 bg-slate-50/30 space-y-6">
        <div class="flex justify-between items-center">
          <span class="text-[10px] font-black text-slate-400 uppercase tracking-widest">Phí vận chuyển</span>
          <span class="text-[10px] font-black text-blue-950 uppercase tracking-widest">Miễn phí</span>
        </div>
        <div class="flex justify-between items-center">
          <span class="text-sm font-black text-blue-950 uppercase tracking-tight">Tổng cộng</span>
          <span class="text-2xl font-black text-orange-500">$2,348.00</span>
        </div>
        
        <button class="w-full bg-blue-950 text-white font-black py-5 rounded-[1.5rem] shadow-2xl shadow-blue-950/20 uppercase tracking-[0.2em] text-[10px] hover:bg-blue-900 transition-all active:scale-[0.98]">
          Thanh toán ngay
        </button>
        
        <div class="flex items-center justify-center gap-2 text-[8px] font-black text-slate-300 uppercase tracking-[0.2em]">
          <span class="material-symbols-outlined text-xs">verified_user</span>
          Thanh toán an toàn bởi Luxe Pay
        </div>
      </div>
    </aside>
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
.custom-scrollbar::-webkit-scrollbar-thumb:hover {
  background: #e2e8f0;
}
</style>
