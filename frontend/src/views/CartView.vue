<script setup lang="ts">
import { ref, computed } from 'vue'

const cartItems = ref([
  {
    id: 1,
    name: 'MacBook Pro 14" M3 Pro',
    category: 'Laptops',
    price: 49990000,
    quantity: 1,
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBnLRLQ-f4WcRw1ElvkghPIYqSlf3hEwj68eJ9S2d2y4eckZR_KPsbfqdOHUhg5mqQhZ_rR4ydICi6tPpPOvgOX4z_O_rHs4trCOZjscoXPcQzpdH-2QWcKpFOyWgKNvRc5x-pQAfI291GWjHgXSZEojqx9a7b3FpmJKn3g30mzXWPoi1RzIumVCD7etEufrcA69D0DKDnxF76QJ0nhfP39k4fNpA26-HhEiaHSi9XNWla8UfSOB7kC2rdZwBl7InnEJEqMxxVh7AoU',
    specs: 'Space Grey | 18GB | 512GB'
  },
  {
    id: 2,
    name: 'Sony WH-1000XM5',
    category: 'Audio',
    price: 8490000,
    quantity: 1,
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuCp9M3ZZToEsb-mKyCa4uYAkKV140UnR-ewPhTQOk9KyHHcrtXVf5L3ag5ffXV75RImwRPxkbKl52LWPBVSrYHzt63TIcbIPqIDqemoZqCncBP-zLhJBfklTViFSgdvyqNzQEdv_N5X8T0wj_YCCwYgWcebz7q-20dmFOcipkHeMFkfZ79e2nlkyV05lpcUIOiwU350izt7WC6rjlfB5zBsj3WJTAJSTQSb8hY2AYjMoRTuZg3rWCERO8IygBgH5pPfUMsUCFJLy31Q',
    specs: 'Black | Noise Canceling'
  }
])

const subtotal = computed(() => cartItems.value.reduce((acc, item) => acc + item.price * item.quantity, 0))
const shipping = ref(0) // Free shipping
const total = computed(() => subtotal.value + shipping.value)

const formatPrice = (price: number) => {
  return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(price)
}

const updateQty = (id: number, delta: number) => {
  const item = cartItems.value.find(i => i.id === id)
  if (item) {
    item.quantity = Math.max(1, item.quantity + delta)
  }
}

const removeItem = (id: number) => {
  cartItems.value = cartItems.value.filter(i => i.id !== id)
}
</script>

<template>
  <div class="max-w-7xl mx-auto px-8 py-16">
    <h1 class="text-4xl font-black text-blue-950 mb-12">Giỏ hàng của bạn</h1>

    <div v-if="cartItems.length > 0" class="flex flex-col lg:flex-row gap-16 items-start">
      <!-- Items List -->
      <div class="flex-grow space-y-8 w-full lg:w-3/5">
        <div v-for="item in cartItems" :key="item.id" class="flex flex-col md:flex-row gap-8 pb-8 border-b border-slate-100 group">
          <!-- Image -->
          <div class="w-32 h-32 bg-slate-50 border border-slate-100 rounded-2xl flex-shrink-0 p-4">
            <img :src="item.image" :alt="item.name" class="w-full h-full object-contain">
          </div>
          <!-- Info -->
          <div class="flex-grow flex flex-col justify-between">
            <div class="flex justify-between items-start">
              <div>
                <h3 class="text-lg font-black text-blue-950 group-hover:text-blue-700 transition-colors">{{ item.name }}</h3>
                <p class="text-xs font-bold text-slate-400 uppercase tracking-widest mt-1">{{ item.specs }}</p>
              </div>
              <button @click="removeItem(item.id)" class="text-slate-300 hover:text-red-500 transition-colors">
                <span class="material-symbols-outlined">delete</span>
              </button>
            </div>
            
            <div class="flex justify-between items-end mt-4">
              <!-- Qty Control -->
              <div class="flex items-center bg-slate-100 rounded-xl p-1">
                <button @click="updateQty(item.id, -1)" class="w-8 h-8 flex items-center justify-center hover:bg-white rounded-lg transition-all text-blue-950">
                  <span class="material-symbols-outlined text-sm">remove</span>
                </button>
                <span class="w-10 text-center font-black text-sm text-blue-950">{{ item.quantity }}</span>
                <button @click="updateQty(item.id, 1)" class="w-8 h-8 flex items-center justify-center hover:bg-white rounded-lg transition-all text-blue-950">
                  <span class="material-symbols-outlined text-sm">add</span>
                </button>
              </div>
              <!-- Price -->
              <div class="text-xl font-black text-blue-950">{{ formatPrice(item.price) }}</div>
            </div>
          </div>
        </div>
      </div>

      <!-- Summary -->
      <aside class="w-full lg:w-2/5 bg-white border border-slate-100 rounded-[2.5rem] p-10 shadow-xl shadow-slate-200/50 sticky top-32">
        <h2 class="text-xl font-black text-blue-950 mb-8 uppercase tracking-widest">Tóm tắt đơn hàng</h2>
        <div class="space-y-6">
          <div class="flex justify-between items-center text-slate-500 font-bold">
            <span>Tạm tính</span>
            <span class="text-blue-950">{{ formatPrice(subtotal) }}</span>
          </div>
          <div class="flex justify-between items-center text-slate-500 font-bold">
            <span>Vận chuyển</span>
            <span class="text-green-600">Miễn phí</span>
          </div>
          <div class="pt-6 border-t border-slate-100 flex justify-between items-center">
            <span class="text-lg font-black text-blue-950">Tổng cộng</span>
            <div class="text-right">
              <span class="text-3xl font-black text-blue-950">{{ formatPrice(total) }}</span>
              <p class="text-[10px] text-slate-400 font-black uppercase tracking-widest mt-1">Đã bao gồm VAT</p>
            </div>
          </div>
          
          <button class="w-full py-5 bg-orange-500 text-white font-black rounded-2xl hover:bg-orange-600 active:scale-95 transition-all shadow-2xl shadow-orange-200 uppercase tracking-widest text-lg cursor-pointer mt-8">
            Thanh toán ngay
          </button>
          
          <div class="pt-8 space-y-4">
            <div class="flex items-center gap-3 text-slate-400">
              <span class="material-symbols-outlined text-sm">shield</span>
              <span class="text-[10px] font-black uppercase tracking-widest">Thanh toán an toàn 100%</span>
            </div>
            <div class="flex items-center gap-3 text-slate-400">
              <span class="material-symbols-outlined text-sm">local_shipping</span>
              <span class="text-[10px] font-black uppercase tracking-widest">Giao hàng nhanh 2h</span>
            </div>
          </div>
        </div>
      </aside>
    </div>

    <!-- Empty State -->
    <div v-else class="text-center py-32 space-y-8">
      <div class="w-32 h-32 bg-slate-100 rounded-full flex items-center justify-center mx-auto mb-8">
        <span class="material-symbols-outlined text-6xl text-slate-300">shopping_cart</span>
      </div>
      <h2 class="text-3xl font-black text-blue-950">Giỏ hàng đang trống</h2>
      <p class="text-slate-400 font-bold max-w-md mx-auto">Có vẻ như bạn chưa chọn được món đồ công nghệ nào ưng ý.</p>
      <router-link to="/products" class="inline-block px-12 py-5 bg-blue-950 text-white font-black rounded-2xl hover:bg-blue-900 transition-all uppercase tracking-widest shadow-xl shadow-blue-900/20">
        Khám phá ngay
      </router-link>
    </div>
  </div>
</template>
