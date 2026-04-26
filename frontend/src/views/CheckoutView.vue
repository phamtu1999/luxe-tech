<script setup lang="ts">
import { ref } from 'vue'

const formData = ref({
  fullName: '',
  phone: '',
  address: '',
  city: '',
  district: '',
  note: ''
})

const paymentMethod = ref('cod')

const orderItems = [
  {
    name: 'MacBook Pro M3 Max 14"',
    specs: 'Space Black | 32GB RAM',
    price: 54990000,
    qty: 1,
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuA_arof8prEG88ofFzRkwJPcnTbN2ezJlLFlNqd6pwtmYan8bwhaAUNgxooIPxQCKR0E-Qxuye-BnnLJpMuklkr7_BoByGi5veyzGquF-HqZwxIe-_kRv8pOyQm1Fc-8ZXJaGWf_IFMUhFfwV3S0D9pGN5143RaQ_CxEpj4lwRX_461BB8Ifj4VZaygBI9yTVvG3QTsimFxPoups1HDDNTH-EmJmBM1_2zPb7YEj1weSf2PkauV4whfw5hbJTA3IQvpP-1x3AoYhbqE'
  },
  {
    name: 'Sony WH-1000XM5',
    specs: 'Đen Midnight',
    price: 8490000,
    qty: 1,
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuDkBY1gq5VDzsl1UF-GgWxliIAjKIxvUzn0efOdU8CPUFLNo5Hyw_F6NKWR4cvuKiYOxOSOVb5HSiqle1_MmVy_kv7nlGaDepXQsm-P25IikLFssVGFgyYx42qPuj0EtmuzvRiqrwQZYOhM8Bi-sl-98m7cUAx6_OJrU0YM_Y7JpdR6l13nscXdRMLPCe861ZB6d87m6znpbmSExGmcAT4eohF9wPc6iGrD0SVoo2dkJwlJDPMpSgrtQRTk4-MpPtJS3BdfmF3iY-x7'
  }
]

const subtotal = 63480000
const discount = 200000
const total = subtotal - discount

const formatPrice = (p: number) => new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(p)
</script>

<template>
  <div class="max-w-7xl mx-auto px-8 py-12">
    <!-- Steps -->
    <div class="flex items-center justify-center gap-8 mb-16">
      <div class="flex items-center gap-3">
        <span class="w-8 h-8 rounded-full border-2 border-blue-900 flex items-center justify-center font-black text-xs text-blue-900">1</span>
        <span class="text-sm font-black text-blue-900 uppercase tracking-widest">Giỏ hàng</span>
      </div>
      <div class="w-12 h-[2px] bg-slate-100"></div>
      <div class="flex items-center gap-3">
        <span class="w-8 h-8 rounded-full bg-blue-900 flex items-center justify-center font-black text-xs text-white">2</span>
        <span class="text-sm font-black text-blue-900 uppercase tracking-widest">Thanh toán</span>
      </div>
      <div class="w-12 h-[2px] bg-slate-100"></div>
      <div class="flex items-center gap-3 opacity-30">
        <span class="w-8 h-8 rounded-full border-2 border-slate-300 flex items-center justify-center font-black text-xs text-slate-400">3</span>
        <span class="text-sm font-black text-slate-400 uppercase tracking-widest">Hoàn tất</span>
      </div>
    </div>

    <div class="flex flex-col lg:flex-row gap-16">
      <!-- Shipping & Payment -->
      <div class="w-full lg:w-3/5 space-y-12">
        <section class="bg-white p-10 rounded-[2.5rem] border border-slate-100 shadow-sm">
          <h2 class="text-2xl font-black text-blue-950 mb-8 flex items-center gap-4">
            <span class="material-symbols-outlined text-blue-600">local_shipping</span>
            Thông tin giao hàng
          </h2>
          <form class="space-y-6">
            <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
              <div class="space-y-2">
                <label class="text-[10px] font-black text-slate-400 uppercase tracking-widest">Họ và tên</label>
                <input v-model="formData.fullName" class="w-full border-b-2 border-slate-50 py-3 focus:border-blue-900 focus:ring-0 outline-none bg-transparent font-bold text-blue-950 transition-colors" placeholder="Nguyễn Văn A">
              </div>
              <div class="space-y-2">
                <label class="text-[10px] font-black text-slate-400 uppercase tracking-widest">Số điện thoại</label>
                <input v-model="formData.phone" class="w-full border-b-2 border-slate-50 py-3 focus:border-blue-900 focus:ring-0 outline-none bg-transparent font-bold text-blue-950 transition-colors" placeholder="0901 234 567">
              </div>
            </div>
            <div class="space-y-2">
              <label class="text-[10px] font-black text-slate-400 uppercase tracking-widest">Địa chỉ chi tiết</label>
              <input v-model="formData.address" class="w-full border-b-2 border-slate-50 py-3 focus:border-blue-900 focus:ring-0 outline-none bg-transparent font-bold text-blue-950 transition-colors" placeholder="Số nhà, tên đường, phường/xã...">
            </div>
            <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
              <input v-model="formData.city" class="border-b-2 border-slate-50 py-3 focus:border-blue-900 focus:ring-0 outline-none bg-transparent font-bold text-blue-950 transition-colors" placeholder="Tỉnh/Thành phố">
              <input v-model="formData.district" class="border-b-2 border-slate-50 py-3 focus:border-blue-900 focus:ring-0 outline-none bg-transparent font-bold text-blue-950 transition-colors" placeholder="Quận/Huyện">
            </div>
          </form>
        </section>

        <section class="bg-white p-10 rounded-[2.5rem] border border-slate-100 shadow-sm">
          <h2 class="text-2xl font-black text-blue-950 mb-8 flex items-center gap-4">
            <span class="material-symbols-outlined text-blue-600">payments</span>
            Phương thức thanh toán
          </h2>
          <div class="space-y-4">
            <label v-for="method in [
              { id: 'cod', name: 'Thanh toán khi nhận hàng (COD)', desc: 'Kiểm tra sản phẩm trước khi thanh toán', icon: 'payments' },
              { id: 'vnpay', name: 'VNPay / MoMo', desc: 'Thanh toán nhanh qua ứng dụng di động', icon: 'account_balance_wallet' },
              { id: 'bank', name: 'Chuyển khoản ngân hàng', desc: 'Xác nhận đơn hàng sau khi nhận tiền', icon: 'account_balance' }
            ]" :key="method.id" 
              class="flex items-center p-6 border-2 rounded-2xl cursor-pointer transition-all group"
              :class="paymentMethod === method.id ? 'border-blue-950 bg-blue-50/30' : 'border-slate-50 hover:border-slate-200'">
              <input type="radio" v-model="paymentMethod" :value="method.id" class="w-5 h-5 text-blue-950 focus:ring-blue-950 border-slate-300">
              <div class="ml-6 flex items-center gap-6">
                <span class="material-symbols-outlined text-blue-900 text-3xl">{{ method.icon }}</span>
                <div>
                  <p class="font-black text-blue-950">{{ method.name }}</p>
                  <p class="text-xs font-bold text-slate-400 mt-1">{{ method.desc }}</p>
                </div>
              </div>
            </label>
          </div>
        </section>
      </div>

      <!-- Order Summary -->
      <aside class="w-full lg:w-2/5 space-y-8">
        <div class="bg-white p-10 rounded-[2.5rem] border border-slate-100 shadow-xl shadow-slate-200/50 sticky top-32">
          <h2 class="text-xl font-black text-blue-950 mb-8 uppercase tracking-widest">Tóm tắt đơn hàng</h2>
          
          <div class="divide-y divide-slate-50 mb-8">
            <div v-for="item in orderItems" :key="item.name" class="py-4 flex gap-6 items-start group">
              <div class="w-16 h-16 bg-slate-50 rounded-xl overflow-hidden flex-shrink-0 border border-slate-100">
                <img :src="item.image" class="w-full h-full object-contain">
              </div>
              <div class="flex-grow">
                <h4 class="text-sm font-black text-blue-950 leading-tight group-hover:text-blue-700 transition-colors">{{ item.name }}</h4>
                <p class="text-[10px] font-bold text-slate-400 mt-1 uppercase tracking-widest">{{ item.specs }}</p>
                <div class="flex justify-between items-center mt-2">
                  <p class="text-[10px] font-black text-slate-400">SL: {{ item.qty }}</p>
                  <p class="text-sm font-black text-blue-950">{{ formatPrice(item.price) }}</p>
                </div>
              </div>
            </div>
          </div>

          <div class="space-y-4 pt-6 border-t border-slate-100 mb-8">
            <div class="flex justify-between text-sm font-bold text-slate-400">
              <span>Tạm tính</span>
              <span class="text-blue-950">{{ formatPrice(subtotal) }}</span>
            </div>
            <div class="flex justify-between text-sm font-bold text-slate-400">
              <span>Phí vận chuyển</span>
              <span class="text-green-600">Miễn phí</span>
            </div>
            <div class="flex justify-between text-sm font-bold text-orange-500">
              <span>Giảm giá</span>
              <span>-{{ formatPrice(discount) }}</span>
            </div>
            <div class="pt-6 border-t border-slate-100 flex justify-between items-end">
              <span class="text-lg font-black text-blue-950">Tổng tiền</span>
              <div class="text-right">
                <p class="text-3xl font-black text-orange-500">{{ formatPrice(total) }}</p>
                <p class="text-[10px] text-slate-400 font-black uppercase tracking-widest mt-1">Đã bao gồm VAT</p>
              </div>
            </div>
          </div>

          <button class="w-full py-5 bg-blue-950 text-white font-black rounded-2xl hover:bg-blue-900 active:scale-95 transition-all shadow-xl shadow-blue-900/20 uppercase tracking-widest text-lg cursor-pointer">
            Xác nhận đặt hàng
          </button>
          
          <div class="mt-8 flex items-start gap-4 p-4 bg-blue-50/50 rounded-2xl border border-blue-100/50">
            <span class="material-symbols-outlined text-blue-600 text-xl">shield</span>
            <p class="text-[10px] font-bold text-blue-900/60 leading-relaxed">Giao dịch của bạn được bảo mật tuyệt đối bởi hệ thống mã hóa 256-bit chuẩn SSL quốc tế.</p>
          </div>
        </div>
      </aside>
    </div>
  </div>
</template>
