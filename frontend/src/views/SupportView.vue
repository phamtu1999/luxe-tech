<script setup lang="ts">
import { ref } from 'vue'

const openFaq = ref(2) // Default open item 2

const faqs = [
  { id: 0, q: 'Làm thế nào để kiểm tra tình trạng bảo hành?', a: 'Bạn có thể tra cứu thông tin bảo hành bằng cách nhập số Serial Number hoặc IMEI của sản phẩm vào trang Tra cứu bảo hành hoặc liên hệ trực tiếp qua hotline.' },
  { id: 1, q: 'LUXE-TECH có hỗ trợ trả góp không?', a: 'Chúng tôi hỗ trợ trả góp 0% lãi suất qua thẻ tín dụng của hơn 20 ngân hàng liên kết hoặc qua các công ty tài chính như Home Credit, FE Credit.' },
  { id: 2, q: 'Chính sách giao hàng hỏa tốc trong 2 giờ?', a: 'Chúng tôi cung cấp dịch vụ giao hàng hỏa tốc trong vòng 2 giờ cho các đơn hàng nội thành Hà Nội và TP.HCM đối với các sản phẩm có sẵn tại kho.' },
  { id: 3, q: 'Tôi có thể hủy đơn hàng sau khi đã thanh toán không?', a: 'Bạn có thể hủy đơn hàng trước khi trạng thái đơn hàng chuyển sang "Đang giao". Số tiền sẽ được hoàn lại trong vòng 3-5 ngày làm việc.' }
]

const toggleFaq = (id: number) => {
  openFaq.value = openFaq.value === id ? -1 : id
}
</script>

<template>
  <div class="min-h-screen">
    <!-- Hero Section -->
    <section class="bg-gradient-to-br from-[#001e40] to-[#003366] py-32 px-8">
      <div class="max-w-4xl mx-auto text-center">
        <h1 class="text-5xl font-black text-white mb-6">Trung tâm hỗ trợ</h1>
        <p class="text-xl font-bold text-blue-200 opacity-80 mb-12">Chúng tôi luôn sẵn sàng giải đáp mọi thắc mắc của bạn về sản phẩm và dịch vụ.</p>
        <div class="relative max-w-2xl mx-auto">
          <span class="material-symbols-outlined absolute left-6 top-1/2 -translate-y-1/2 text-slate-400">search</span>
          <input class="w-full pl-16 pr-8 py-6 rounded-3xl border-none shadow-2xl shadow-black/20 focus:ring-4 focus:ring-blue-500/20 bg-white font-bold text-blue-950" placeholder="Bạn cần hỗ trợ gì?">
        </div>
      </div>
    </section>

    <!-- Support Categories -->
    <section class="max-w-7xl mx-auto px-8 py-24">
      <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-8">
        <div v-for="cat in [
          { name: 'Bảo hành', desc: 'Tra cứu thông tin chính sách bảo hành.', icon: 'verified_user' },
          { name: 'Đổi trả', desc: 'Quy trình đổi trả trong 30 ngày.', icon: 'assignment_return' },
          { name: 'Hướng dẫn', desc: 'Thiết lập và sử dụng sản phẩm.', icon: 'menu_book' },
          { name: 'Thanh toán', desc: 'Phương thức và bảo mật giao dịch.', icon: 'payments' }
        ]" :key="cat.name" class="group bg-white p-10 rounded-[2.5rem] border border-slate-100 hover:shadow-2xl hover:shadow-slate-200/50 transition-all duration-500 cursor-pointer">
          <div class="w-16 h-16 bg-slate-50 rounded-2xl flex items-center justify-center text-blue-900 mb-8 group-hover:bg-blue-950 group-hover:text-white transition-all">
            <span class="material-symbols-outlined text-3xl">{{ cat.icon }}</span>
          </div>
          <h3 class="text-xl font-black text-blue-950 mb-3">{{ cat.name }}</h3>
          <p class="text-sm font-bold text-slate-400 leading-relaxed">{{ cat.desc }}</p>
        </div>
      </div>
    </section>

    <!-- FAQ -->
    <section class="bg-white py-24">
      <div class="max-w-3xl mx-auto px-8">
        <div class="text-center mb-16">
          <h2 class="text-3xl font-black text-blue-950 mb-4">Câu hỏi thường gặp</h2>
          <div class="w-16 h-1.5 bg-orange-500 mx-auto rounded-full"></div>
        </div>
        <div class="space-y-4">
          <div v-for="faq in faqs" :key="faq.id" class="border border-slate-100 rounded-3xl overflow-hidden bg-white shadow-sm hover:shadow-md transition-all">
            <button @click="toggleFaq(faq.id)" class="w-full px-8 py-6 flex justify-between items-center text-left">
              <span class="font-black text-blue-950" :class="openFaq === faq.id ? 'text-orange-500' : ''">{{ faq.q }}</span>
              <span class="material-symbols-outlined transition-transform duration-300" :class="openFaq === faq.id ? 'rotate-180 text-orange-500' : 'text-slate-300'">expand_more</span>
            </button>
            <div v-show="openFaq === faq.id" class="px-8 pb-8">
              <div class="pt-4 border-t border-slate-50 text-sm font-bold text-slate-400 leading-relaxed">
                {{ faq.a }}
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Contact Bento -->
    <section class="max-w-7xl mx-auto px-8 py-24">
      <div class="grid grid-cols-1 lg:grid-cols-3 gap-8">
        <div class="lg:col-span-2 bg-blue-950 rounded-[3rem] p-16 text-white relative overflow-hidden flex flex-col justify-between min-h-[400px]">
          <div class="relative z-10">
            <h2 class="text-4xl font-black mb-6">Vẫn cần sự giúp đỡ?</h2>
            <p class="text-lg font-bold text-blue-200 max-w-md opacity-80">Đội ngũ chuyên gia của chúng tôi luôn sẵn sàng hỗ trợ bạn 24/7 qua các kênh liên lạc trực tiếp.</p>
          </div>
          <div class="flex flex-wrap gap-4 relative z-10">
            <button class="bg-orange-500 text-white px-10 py-5 font-black rounded-2xl shadow-xl shadow-orange-500/20 hover:bg-orange-600 transition-all text-xs uppercase tracking-widest">Gọi hotline ngay</button>
            <button class="bg-white/10 backdrop-blur-xl text-white border border-white/20 px-10 py-5 font-black rounded-2xl hover:bg-white/20 transition-all text-xs uppercase tracking-widest">Gửi Email</button>
          </div>
          <div class="absolute -right-16 -bottom-16 opacity-10">
            <span class="material-symbols-outlined text-[300px] select-none" style="font-variation-settings: 'FILL' 1">support_agent</span>
          </div>
        </div>
        <div class="bg-slate-50 rounded-[3rem] p-16 flex flex-col items-center text-center justify-center border border-slate-100 shadow-sm">
          <div class="w-24 h-24 mb-8 relative">
            <img src="https://i.pravatar.cc/150?u=support" class="w-full h-full object-cover rounded-full border-4 border-white shadow-xl">
            <div class="absolute bottom-2 right-2 w-6 h-6 bg-green-500 border-4 border-white rounded-full"></div>
          </div>
          <h4 class="text-2xl font-black text-blue-950">Tư vấn trực tiếp</h4>
          <p class="text-sm font-bold text-slate-400 mt-2 mb-8">Thời gian phản hồi: 2 phút</p>
          <button class="w-full bg-blue-950 text-white py-5 rounded-2xl font-black active:scale-95 transition-all text-xs uppercase tracking-widest shadow-xl shadow-blue-900/20">Bắt đầu trò chuyện</button>
        </div>
      </div>
    </section>

    <!-- Chat FAB -->
    <div class="fixed bottom-12 right-12 z-50 flex flex-col items-end group">
      <div class="bg-white p-6 rounded-3xl shadow-2xl border border-slate-100 mb-6 w-72 scale-0 group-hover:scale-100 origin-bottom-right transition-all duration-500">
        <div class="flex items-center gap-2 mb-3">
          <div class="w-2 h-2 bg-green-500 rounded-full animate-pulse"></div>
          <span class="text-[10px] font-black text-slate-400 uppercase tracking-widest">Đang trực tuyến</span>
        </div>
        <p class="text-sm font-black text-blue-950 mb-4">Chào bạn! Tôi có thể giúp gì cho bạn hôm nay?</p>
        <div class="flex gap-2">
          <span class="px-3 py-1.5 bg-slate-50 rounded-lg text-[10px] font-black text-slate-500 border border-slate-100 cursor-pointer hover:bg-white hover:border-blue-950 hover:text-blue-950 transition-all">Tra cứu đơn hàng</span>
          <span class="px-3 py-1.5 bg-slate-50 rounded-lg text-[10px] font-black text-slate-500 border border-slate-100 cursor-pointer hover:bg-white hover:border-blue-950 hover:text-blue-950 transition-all">Bảo hành</span>
        </div>
      </div>
      <button class="w-16 h-16 bg-orange-500 text-white rounded-full flex items-center justify-center shadow-2xl shadow-orange-500/40 hover:scale-110 active:scale-95 transition-all">
        <span class="material-symbols-outlined text-3xl" style="font-variation-settings: 'FILL' 1">chat</span>
      </button>
    </div>
  </div>
</template>
