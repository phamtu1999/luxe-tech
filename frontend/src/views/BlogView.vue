<script setup lang="ts">
import { ref } from 'vue'

const featuredArticle = {
  category: 'Hardware Review',
  title: 'The Future of Productivity: Evaluating the New LUXE-Book Pro 2024',
  excerpt: 'An in-depth look at how the latest architectural breakthroughs in silicon are redefining what we expect from professional workstations.',
  author: 'Alex Thorne',
  readTime: '12 Min Read',
  image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuCUc9kfRz20EjCGRTblTuU2AvNkdKl_fu4QcRULCsY0frCTrfVSrP0x7ASRpsXtn1wjii5i_4dgp9xIcPqi0iRK5rzK1ozI0j7nLDqHJY_atDI73-v48yWlMobmEP_UoJ8iK3sVaT4NXgtoVSaVf_FQVXLNAAU9-7P4pFfqW-CMrfWkl-ogocrS6TXDADwyxZNg8cQO6KbIzK0EDY3DKSKlQkREW3JzkbkEE7v74n2jevwu-mQpM3oxftRcoH5qClCji2LRE_taaZ12'
}

const trending = [
  { id: '01', category: 'SOFTWARE', title: 'Quantum Encryption: Is your data actually safe from future threats?' },
  { id: '02', category: 'LIFESTYLE', title: 'Digital Minimalism: Why top CEOs are switching back to analog tools.' },
  { id: '03', category: 'AUDIO', title: 'Spatial Audio 2.0: The next frontier for immersive mobile experiences.' }
]

const articles = [
  {
    date: 'July 24, 2024',
    title: 'The Resurgence of Analog Tech in a Digital World',
    excerpt: 'Why younger generations are flocking back to film cameras, vinyl records, and mechanical keyboards for a tactile connection.',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuCkD_Ef1ApJYNsoRmvKoUgXbrM3O-HgaIDNjtf6X3AUWGsE2WX9pX_UtRkYQBX6GkW8ILqJME3lGjZS2dGtTZc93i1pY7iQLCcJIppAvlgEeDqmWp7PhaRymujCJgDtFKUg5yOedrV7fd-WrE5h9g1ohSyiUeV4l1lAvgQeplYcxJpGewQz9lBWcf24sOr4ffA11MbW5uR9Nnpy4MeflPghVAH5aO_yc-2HwvLi3Bs-P5XOca4sWHcHQZFyFqdNS-ztIANILiVXro0D',
    product: {
      name: 'Tactile Mini Pro Keyboard',
      price: '$189.00',
      image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuAmobvNtFpSeE_yvYC-AQZNQpYeU_uVblJaTaTtaxcyn15oBkAvhe4mXf0l4GfP6bkoeFG9OSdXJtwyzpB6I7X_6H6RMuw0bJw8Xvir08YuEfq6d8LqMGYXWYnvbYb3yUT6YtVezg9BQvtOKUjmsrZ6_nj9YTHec7oDnXt5U1KFWUnLCx6S54jzaDTAXOYzYyJVdvqiN7gdrOQC9r75sqG7XgiNsfX4Vj5HH7aShj44HFomyhpoGyZAyIPcfHfHc01TfwkoY399UAzs'
    }
  },
  {
    date: 'July 22, 2024',
    title: 'Creativity Unleashed: The Best Tablets for Artists in 2024',
    excerpt: 'Comparing color accuracy, stylus latency, and software ecosystems for the professional digital creative.',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBN92h76bRd54APsKqr38e5TsE2rjljKLBldm6RtfEt_VSCMiIzl2yW25x7ruJu-e7P9CiBhmpFm0gU5MG0TPuT8ISUMmrnK6_g6r26PtBuIgOVy-I9A_fnCKos0YiC2VCLC7DT-Kc7UEXrQn9qYByf8cgC1M_ahwfXfbqEXWL6w9j9glHTOkGNJ2XJsUM0EcbG-QRRTBLYD5o9bqCzzG5x5KtbjtNJNmpb9hiv6r-8-Cyt1e6EIHf5ctidiwmb5GLuAYD25V2bUHDs',
    product: {
      name: 'LUXE-Tab Ultra OLED',
      price: '$1,299.00',
      image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuDfWXkyY8Gy9XjIyDobOFy0KuGwsO-YPOHf7nd6HX8i-NA_3_zVy_BtphWqxGP8ntkD7rQXVm0JfS5gLoDDhsIm4wiU-uzAQoiUTvdNnp7xdPw_cfAh7rZkttyJxcfOOYiknDUM_mQcXU27w1bdnQqlCL7HaNaWmB9zYRT3Z_McTvps9inDS_pY_HzUuhOzJ6l8zAl8wiTZKQQ6UCR4oAhVbFZCjEuuNo70AllWfpVBxaD0q_9AUlAc-umIHasVDKtVGNw10ieGlZKd'
    }
  },
  {
    date: 'July 20, 2024',
    title: 'Audiophile Grade Wireless: The Impossible Dream?',
    excerpt: 'Testing lossless Bluetooth codecs against traditional wired setups in a blind studio environment.',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuCr1CY15Vejbce-u64ukW5KSyo6S4uwW7i9a94BNKQQZJCVoN9ZeDpJnn9d5_-atfO-e5K9s9to2yChL8GG4g9wulH6utj8ZEVgKW7iSqh7b1epEhX7FDaafPt_mprL1sGRykF17CEinTcqWuUoUMSycvxlaAplh--fGKmCncW5zIOtbnayTRd9_VhyroU1xJpxQpikWCsHPdN1PVCmmcXaE6uOihaTk3kwgb9hkhhvVz4Rqspcbo7gF4gCJ7ipK7NzUCT2w4evXHvU',
    product: {
      name: 'Acoustix Wireless Elite',
      price: '$449.00',
      image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuDCg8uP6ha-f5v3vsMYP1W6_7VPXoAH-wiMXCVEOp0BapjQ_0YMVpapxw5nfhfI07NUspt3j2YGhDeKZJDdDtVFo52rmw1HePOhjD-kkToRCLpE5Iw-WaGqGHmtVz-Nnt-8Jt2QVylcHC_tEd_TDjz9K3gYnMIwT1YtoLlXoeEnGtGe3LpAmqITHAkPjZfeh_lW_DUbKi4BPuGY4pdGarPw5dZooag8nHU4q99DuzIqBWqKAW7xcvVw9H6AKlLsgG9WTvJUTASi4wNn'
    }
  }
]
</script>

<template>
  <div class="max-w-[1440px] mx-auto px-12 py-16">
    <!-- Featured Section -->
    <section class="grid grid-cols-1 lg:grid-cols-12 gap-12 mb-24">
      <div class="lg:col-span-8 group cursor-pointer">
        <div class="aspect-[16/9] overflow-hidden bg-slate-50 rounded-[2.5rem] mb-10 shadow-2xl shadow-slate-200/50">
          <img :src="featuredArticle.image" class="w-full h-full object-cover group-hover:scale-105 transition-transform duration-700">
        </div>
        <div class="max-w-3xl">
          <span class="text-[10px] font-black text-orange-500 uppercase tracking-[0.2em] mb-4 block">{{ featuredArticle.category }}</span>
          <h1 class="text-5xl font-black text-blue-950 mb-6 leading-[1.1] group-hover:text-blue-700 transition-colors">{{ featuredArticle.title }}</h1>
          <p class="text-lg font-bold text-slate-400 mb-10 leading-relaxed">{{ featuredArticle.excerpt }}</p>
          <div class="flex items-center gap-4">
            <img src="https://i.pravatar.cc/150?u=alex" class="w-12 h-12 rounded-full border-2 border-white shadow-lg">
            <div>
              <p class="text-sm font-black text-blue-950">{{ featuredArticle.author }}</p>
              <p class="text-[10px] font-bold text-slate-300 uppercase tracking-widest">{{ featuredArticle.readTime }}</p>
            </div>
          </div>
        </div>
      </div>

      <!-- Trending Sidebar -->
      <div class="lg:col-span-4 flex flex-col gap-12">
        <div class="flex items-center gap-4">
          <div class="w-1.5 h-8 bg-blue-950 rounded-full"></div>
          <h3 class="text-2xl font-black text-blue-950 uppercase tracking-tight">Xu hướng</h3>
        </div>
        <div class="flex flex-col gap-10">
          <div v-for="item in trending" :key="item.id" class="group cursor-pointer">
            <span class="text-[10px] font-black text-orange-500 mb-2 block tracking-widest">{{ item.id }} / {{ item.category }}</span>
            <h4 class="text-lg font-black text-blue-950 group-hover:text-blue-700 transition-colors leading-snug">{{ item.title }}</h4>
          </div>
        </div>
        <div class="mt-auto bg-blue-950 rounded-[2.5rem] p-10 text-white relative overflow-hidden">
          <div class="relative z-10">
            <h5 class="text-xl font-black mb-4">Newsletter</h5>
            <p class="text-sm font-bold text-blue-200 mb-8 leading-relaxed">Nhận những phân tích công nghệ sâu sắc nhất hàng tuần.</p>
            <div class="space-y-4">
              <input class="w-full bg-white/10 border-b-2 border-white/20 text-white placeholder:text-white/40 px-0 py-3 focus:outline-none focus:border-white transition-colors font-bold text-sm" placeholder="Email của bạn">
              <button class="w-full bg-orange-500 text-white py-4 rounded-xl font-black text-[10px] uppercase tracking-[0.2em] hover:bg-orange-600 transition-all active:scale-95">Đăng ký ngay</button>
            </div>
          </div>
          <div class="absolute -right-8 -bottom-8 w-32 h-32 bg-white/5 rounded-full blur-2xl"></div>
        </div>
      </div>
    </section>

    <!-- Latest Feed -->
    <section class="mb-24">
      <div class="flex justify-between items-end mb-16">
        <h2 class="text-3xl font-black text-blue-950">Góc nhìn công nghệ</h2>
        <a href="#" class="text-[10px] font-black text-blue-950 uppercase tracking-[0.2em] border-b-2 border-blue-950 pb-1 hover:text-orange-500 hover:border-orange-500 transition-all">Tất cả bài viết</a>
      </div>
      <div class="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-12">
        <div v-for="article in articles" :key="article.title" class="group flex flex-col h-full">
          <div class="aspect-video overflow-hidden bg-slate-50 rounded-[2rem] mb-8 shadow-sm">
            <img :src="article.image" class="w-full h-full object-cover group-hover:scale-110 transition-transform duration-700">
          </div>
          <div class="flex-1 flex flex-col">
            <span class="text-[10px] font-black text-slate-300 uppercase tracking-widest mb-3">{{ article.date }}</span>
            <h3 class="text-xl font-black text-blue-950 mb-4 group-hover:text-blue-700 transition-colors leading-tight">{{ article.title }}</h3>
            <p class="text-sm font-bold text-slate-400 line-clamp-3 mb-8 leading-relaxed">{{ article.excerpt }}</p>
            
            <!-- Featured Product in Article -->
            <div class="mt-auto bg-slate-50/50 border border-slate-100 p-4 rounded-2xl flex items-center gap-4 hover:bg-white hover:shadow-xl hover:shadow-slate-200/50 transition-all cursor-pointer">
              <div class="w-14 h-14 bg-white border border-slate-50 rounded-xl flex-shrink-0 flex items-center justify-center p-2">
                <img :src="article.product.image" class="w-full h-full object-contain">
              </div>
              <div class="overflow-hidden">
                <span class="text-[8px] font-black text-orange-500 uppercase tracking-widest block mb-1">Featured Gear</span>
                <h4 class="text-xs font-black text-blue-950 truncate">{{ article.product.name }}</h4>
                <div class="flex justify-between items-center mt-1">
                  <span class="text-xs font-black text-blue-950">{{ article.product.price }}</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Deep Dives -->
    <section class="grid grid-cols-1 lg:grid-cols-12 gap-16 py-24 border-t border-slate-50">
      <div class="lg:col-span-5 lg:sticky lg:top-32 h-fit">
        <h2 class="text-4xl font-black text-blue-950 leading-tight mb-6">Báo cáo chuyên sâu & Phân tích kỹ thuật</h2>
        <p class="text-lg font-bold text-slate-400 mb-10 leading-relaxed">Phòng thí nghiệm của LUXE-TECH thực hiện hàng tuần các bài kiểm tra thực tế để đưa ra những phân tích chính xác nhất thị trường.</p>
        <button class="bg-blue-950 text-white px-10 py-5 rounded-2xl font-black text-[10px] uppercase tracking-[0.2em] hover:bg-blue-900 transition-all shadow-xl shadow-blue-950/20">Khám phá kho lưu trữ</button>
      </div>
      <div class="lg:col-span-7 flex flex-col gap-16">
        <div v-for="(h, i) in [
          { tag: 'ANNUAL REPORT', title: 'Silicon Wars: The 2024 Semiconductor Landscape', desc: 'Báo cáo 50 trang về sự thay đổi chuỗi cung ứng và cuộc đua thu nhỏ bóng bán dẫn giữa các tập đoàn hàng đầu.', img: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBFrXclB99lr_M-51_LbD9No-Y_nvHvc_Sq6TZoBq4RMempcxLfLfDXNrHBiFOMNYFBt725t0r7cX4hC8nuC-tVr9ltc-5F46jxBBf88TsdrjMPoXwDOvPF5tq3nkbyiJAyPoKhEK3Sc0-XJSLJbF2nom8yqaK-LAb3N6wvpOkwsxHfTWHl2DUce_UmtTtto8GnpHQ4cczsblLG7BPohMqX1BRV8mX-CfipYTmIJbMSQUsjdP3W9Vk5YGEAg_2aGsJ5zR-s6y3IUXPj' },
          { tag: 'ETHICS IN TECH', title: 'The Invisible Labor of AI: Automation vs Humanity', desc: 'Điều tra lực lượng lao động toàn cầu đứng sau dữ liệu huấn luyện cung cấp năng lượng cho các mô hình AI hiện nay.', img: 'https://lh3.googleusercontent.com/aida-public/AB6AXuDySUZ-g6NOMItOt7k7elvG3xYwkhzrYzJ_nuOmOQRfbSWGwn9i4F3Sze_tUj_OBXZUY60sLyJwiRZNGLZJCUrHLGnQd98LrdE_Lakyptyj9xxnKkQdNoKOzXHDUva8S66G-BuuIht_kztWKf2h4VXSVdrb9w7BuqfsJphRnJ20NUKYhanzSFAWrDE1bOIfAautLju3e17rQRkd0uAzPgo1RJ8hQ-4a1krFPcMzKxIqNmCNy-tD93Gl0fNoIDarJ5HmTcnzS8ucHxps' }
        ]" :key="h.title" class="flex flex-col md:flex-row gap-8 group cursor-pointer">
          <div class="md:w-1/3 aspect-[4/5] bg-slate-50 rounded-[2rem] overflow-hidden flex-shrink-0 shadow-sm">
            <img :src="h.img" class="w-full h-full object-cover group-hover:scale-110 transition-all duration-700">
          </div>
          <div class="py-4">
            <span class="text-[10px] font-black text-orange-500 tracking-widest">{{ h.tag }}</span>
            <h3 class="text-2xl font-black text-blue-950 mt-3 mb-4 group-hover:text-blue-700 transition-colors leading-tight">{{ h.title }}</h3>
            <p class="text-sm font-bold text-slate-400 leading-relaxed">{{ h.desc }}</p>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
