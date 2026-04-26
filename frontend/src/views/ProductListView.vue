<script setup lang="ts">
import { ref } from 'vue'

const products = ref([
  {
    id: 1,
    name: 'Samsung Galaxy S24 Ultra Titanium',
    price: '28.990.000đ',
    oldPrice: '33.990.000đ',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuAyjEtCouMRwTA0TcPImoGimIP1CTN5lfiLTadLzwqCE737uD2-Ui4y3-cpyegil3xz0Epr5hyuzl4cQXP4u-w4LeDOa2U6JX7p4mmPnobP49cGlOiF77ORP8M4kDODBA874wz3cpnCXXzYusvqt34lxtRTeSUGyaQpsv35cx3uscRnYNjEx6jkOhSXKVumwqUt_HvEJ8d88EUM1mP6ykxACmByezj9sPpKblM2RubdZJqDUVgM97lPDS0UnwNu8_Vyrix1AfYsFYm1',
    rating: 5,
    reviews: 128,
    discount: '-15%',
    inStock: true
  },
  {
    id: 2,
    name: 'iPhone 15 Pro Max Natural Titanium',
    price: '31.490.000đ',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuCm5dXxmRtnLbgKUj5vGJEONzB6jBVmX-KuwpyLlQa6NH5njvH7vMsqNj_w-WUiOPjomyb9SmpDundr7Qa-BINOZw9dXNHwSmcuX7VHhabbvdAcZfPCRV3X3o-TDxTKUaifMRH_cikh7sQ3mG9NOkdZiw-jo4tn9XaPW2JHo3kz1pVEKmDOFOAiWFcPy5uI378Xttkf5RyMVWqqdjv5G87FTi1bEyRxa-2rPHUPseym9iEZSqo1G85vpHZ7uxXZsY6QpxrusBg9rhHY',
    rating: 4.5,
    reviews: 85,
    inStock: true
  },
  {
    id: 3,
    name: 'Google Pixel 8 Pro Obsidian',
    price: '22.500.000đ',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuDL8CL5MlDTlv5Q6aRCUxAYTvQVLNWBnzmND5IEXoafzoVG9K1VfWkbZ9cEctpdqqN-JkH1wa52B1ySemIMzz1ZtH74DrFWi0YCqntRuVSVV5nEgm-JNWI1R6IdV0DBdUE7bajIep3eqNtse7gH8BsLSHd_I4wj7Xc767rjWhNmYqosIFPXgQROVDAGICoWe46oMRD1uDMnjQSMsNStek9pn9mBkeufQD2eqvZUqzdjOVLDLQNyIHyyKpKX-nQA4KF-lYmq0S4sSBWa',
    rating: 5,
    reviews: 42,
    inStock: true
  },
  {
    id: 4,
    name: 'Xiaomi 14 Ultra Ceramic White',
    price: '26.990.000đ',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBj6cr_DyrFIn6Du_eA1Y_1kQ1gimYvs_WZYPEXzPSvguEqETU7DnyGS8k56wG1njI-j91NxbZgBqCTGSxt6x6R9YZfyt98SEiovN0s8sMyn0x-bn8HXM91Dam9O5p51HchrVAULBTE49_-ZJEobby7kqYXa4NKnPiHu_9bq-G2wOlnihU9ADqqUDRxyOHoeJ-u3NqU162zflFjtYsofRswNCMOHvO4QxcUAI4kGFSmJ2XOaqiAPlM1so5v-G7N9gOMJc8Ree-V4CG1',
    rating: 4,
    reviews: 67,
    inStock: false
  },
  {
    id: 5,
    name: 'Samsung Galaxy Z Fold5 Phantom Black',
    price: '35.990.000đ',
    oldPrice: '40.990.000đ',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuA3HArMx4mW1jIh0VNvnczicQY3mApll7l_OGcAEDwId2GbPMQbIaQaDXyhcmpwUkmcC5zUAFHqsLHJRVeps6ipasxn1tjjZ_2KN8xbHvH8ejH0CHwoJS9YijHI9h1STRvVz5mnoqfo1Z2XId5lvrd4i8qppCoIzI2Ya_15lJqXT1Thtae-8er4lm4aiAdnE3nUMjAN_BPMYa43DRezy96h70FM9e3KYBUjBU2LIW9n3yqJob2eTzlsUkjYmy-pgRezbVulRdAR3m8K',
    rating: 5,
    reviews: 156,
    discount: '-12%',
    inStock: true
  },
  {
    id: 6,
    name: 'Sony Xperia 1 V 5G Platinum Silver',
    price: '29.490.000đ',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuBDjXiOD3PhVd7To2TymD5ND4-gXDR68qhot_jSr0_45fgyCDIrOZzPutoha3ECBtRyszvWBt6sbXjaIlOkYD0Ec5H4uBOLu4b0rh8ufb1aXg_hzjktkYYJOvPUeV1ncJMwcO8ZW7RWuGB4r8vJTv-8sJwKs3KDcMMvJx4Dpo6SdZxKJfWBykaVDEXuxmZ2j1CizFBTfMlrKvqxzpv2fR_cdPLy5KzMIjxa0YAfYKDcHh5PbO5wygbK_6UtMZgSSaYvDpd-V8YvygYb',
    rating: 4.5,
    reviews: 92,
    inStock: true
  }
])
</script>

<template>
  <div class="max-w-7xl mx-auto px-8 py-12">
    <div class="flex flex-col lg:flex-row gap-12">
      <!-- Sidebar Filters -->
      <aside class="w-full lg:w-64 flex-shrink-0 space-y-10">
        <div class="flex items-center justify-between pb-4 border-b">
          <h3 class="text-xl font-bold text-blue-900">Bộ lọc</h3>
          <button class="text-sm font-semibold text-orange-500 hover:underline">Xóa tất cả</button>
        </div>

        <!-- Brands -->
        <div class="space-y-4">
          <h4 class="font-bold text-blue-900 uppercase text-xs tracking-widest">Thương hiệu</h4>
          <div class="space-y-3">
            <label v-for="brand in ['Apple', 'Samsung', 'Google', 'Xiaomi', 'Sony']" :key="brand" class="flex items-center gap-3 cursor-pointer group">
              <input type="checkbox" class="w-4 h-4 rounded border-slate-300 text-blue-900 focus:ring-blue-900">
              <span class="text-slate-600 group-hover:text-blue-900 transition-colors">{{ brand }}</span>
            </label>
          </div>
        </div>

        <!-- Price Range -->
        <div class="space-y-4">
          <h4 class="font-bold text-blue-900 uppercase text-xs tracking-widest">Khoảng giá</h4>
          <div class="space-y-3">
            <label class="flex items-center gap-3 cursor-pointer group">
              <input type="radio" name="price" class="w-4 h-4 border-slate-300 text-blue-900 focus:ring-blue-900">
              <span class="text-slate-600 group-hover:text-blue-900 transition-colors">Dưới 10tr</span>
            </label>
            <label class="flex items-center gap-3 cursor-pointer group">
              <input type="radio" name="price" class="w-4 h-4 border-slate-300 text-blue-900 focus:ring-blue-900">
              <span class="text-slate-600 group-hover:text-blue-900 transition-colors">10tr - 20tr</span>
            </label>
            <label class="flex items-center gap-3 cursor-pointer group">
              <input type="radio" name="price" checked class="w-4 h-4 border-slate-300 text-blue-900 focus:ring-blue-900">
              <span class="text-slate-600 group-hover:text-blue-900 transition-colors">Trên 20tr</span>
            </label>
          </div>
        </div>

        <!-- RAM -->
        <div class="space-y-4">
          <h4 class="font-bold text-blue-900 uppercase text-xs tracking-widest">Cấu hình RAM</h4>
          <div class="grid grid-cols-2 gap-2">
            <button v-for="ram in ['8GB', '12GB', '16GB', '32GB']" :key="ram" 
              class="py-2 border border-slate-200 rounded text-xs font-bold hover:border-blue-900 hover:text-blue-900 transition-all"
              :class="ram === '12GB' ? 'bg-blue-900 text-white border-blue-900' : 'bg-white text-slate-600'">
              {{ ram }}
            </button>
          </div>
        </div>
      </aside>

      <!-- Main Product Grid -->
      <section class="flex-grow">
        <!-- Grid Header -->
        <div class="flex flex-col md:flex-row md:items-end justify-between gap-4 mb-10 pb-6 border-b border-slate-100">
          <div>
            <h1 class="text-3xl font-extrabold text-blue-950 mb-2">Điện thoại thông minh</h1>
            <p class="text-slate-500 text-sm">Hiển thị {{ products.length }} sản phẩm cao cấp</p>
          </div>
          <div class="flex items-center gap-4 text-sm">
            <span class="text-slate-400">Sắp xếp:</span>
            <select class="font-bold text-blue-900 bg-transparent border-none focus:ring-0 cursor-pointer">
              <option>Phổ biến nhất</option>
              <option>Giá thấp đến cao</option>
              <option>Giá cao đến thấp</option>
              <option>Mới nhất</option>
            </select>
          </div>
        </div>

        <!-- Products -->
        <div class="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 gap-8">
          <div v-for="product in products" :key="product.id" class="group bg-white border border-slate-100 rounded-2xl overflow-hidden hover:shadow-2xl hover:shadow-slate-200/50 transition-all duration-500">
            <div class="relative aspect-square bg-slate-50 flex items-center justify-center p-8 overflow-hidden">
              <img :src="product.image" :alt="product.name" class="w-full h-full object-contain group-hover:scale-110 transition-transform duration-700">
              <div v-if="product.discount" class="absolute top-4 left-4 bg-orange-500 text-white text-[10px] font-black px-2 py-1 rounded-full">{{ product.discount }}</div>
              <button class="absolute bottom-4 left-4 right-4 bg-blue-950 text-white py-3 rounded-xl font-bold opacity-0 translate-y-4 group-hover:opacity-100 group-hover:translate-y-0 transition-all duration-300 shadow-xl shadow-blue-900/20">
                Thêm vào giỏ hàng
              </button>
            </div>
            <div class="p-6 space-y-3">
              <div class="flex items-center gap-1 text-orange-400">
                <span v-for="i in 5" :key="i" class="material-symbols-outlined text-sm" :style="i <= Math.floor(product.rating) ? 'font-variation-settings: \'FILL\' 1' : ''">star</span>
                <span class="text-[10px] text-slate-400 ml-1">({{ product.reviews }})</span>
              </div>
              <h3 class="font-bold text-blue-900 line-clamp-2 min-h-[3rem] group-hover:text-blue-700 transition-colors">{{ product.name }}</h3>
              <div class="flex items-baseline gap-3">
                <span class="text-xl font-black text-blue-950">{{ product.price }}</span>
                <span v-if="product.oldPrice" class="text-sm text-slate-400 line-through">{{ product.oldPrice }}</span>
              </div>
              <div class="flex items-center gap-2">
                <div class="w-1.5 h-1.5 rounded-full" :class="product.inStock ? 'bg-green-500' : 'bg-slate-300'"></div>
                <span class="text-[10px] font-bold uppercase tracking-wider" :class="product.inStock ? 'text-green-600' : 'text-slate-400'">
                  {{ product.inStock ? 'Còn hàng' : 'Hết hàng' }}
                </span>
              </div>
            </div>
          </div>
        </div>

        <!-- Pagination -->
        <div class="mt-16 flex justify-center items-center gap-3">
          <button class="w-10 h-10 flex items-center justify-center rounded-xl border border-slate-200 hover:border-blue-900 hover:text-blue-900 transition-all">
            <span class="material-symbols-outlined">chevron_left</span>
          </button>
          <button v-for="page in [1, 2, 3]" :key="page" 
            class="w-10 h-10 flex items-center justify-center rounded-xl font-bold transition-all"
            :class="page === 1 ? 'bg-blue-900 text-white shadow-lg shadow-blue-200' : 'border border-slate-200 hover:border-blue-900'">
            {{ page }}
          </button>
          <span class="text-slate-300">...</span>
          <button class="w-10 h-10 flex items-center justify-center rounded-xl border border-slate-200 hover:border-blue-900">12</button>
          <button class="w-10 h-10 flex items-center justify-center rounded-xl border border-slate-200 hover:border-blue-900 hover:text-blue-900 transition-all">
            <span class="material-symbols-outlined">chevron_right</span>
          </button>
        </div>
      </section>
    </div>
  </div>
</template>
