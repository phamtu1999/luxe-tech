<script setup lang="ts">
import { ref } from 'vue'

interface ProductSpecs {
  display: string;
  displaySub: string;
  cpu: string;
  cpuSub: string;
  ramRom: string;
  ramRomSub: string;
  camera: string;
  cameraSub: string;
  battery: string;
  batterySub: string;
  status: string;
  statusColor: string;
  [key: string]: string; // Allow string indexing to fix TS error in template
}

interface Product {
  name: string;
  price: string;
  image: string;
  specs: ProductSpecs;
}

const showDifferencesOnly = ref(false)

const products: Product[] = [
  {
    name: 'Luxe Titan Pro 15',
    price: '32.990.000₫',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuAjSwW5HVA4MX9Dh7s-pGbcax_V-2vBDznx4AfSv1S3RjVP3UvRzceaGTEbaK_ZubX9tqwZA1nfjD5hwB1iV8dIjxAWo4utZ8ljXdl17K-Wp1Lp0qYme069JtsWEKIYPmV_v20IqVxBQcIR05mAE5ik0LddamJlN6wgZNd148ox53hy7MmZANE2sAmE6OQ4eD5EZjxmYdncqahKrt4M8hnrMVPoizsX0ugQCINMqvGREOjnEW5RQTIxU84mvFo3FA4OfmT4HRlg61FH',
    specs: {
      display: '6.7" OLED Super Retina XDR',
      displaySub: '2000 nits, 120Hz ProMotion',
      cpu: 'A17 Pro Chip',
      cpuSub: '6-core CPU, 6-core GPU',
      ramRom: '8GB LPDDR5X',
      ramRomSub: '256GB / 512GB / 1TB',
      camera: 'Main 48MP',
      cameraSub: 'Tele 5x Optical Zoom',
      battery: '4,422 mAh',
      batterySub: '27W Fast Charge / MagSafe',
      status: 'Còn hàng',
      statusColor: 'bg-green-500'
    }
  },
  {
    name: 'Nebula Fold X4',
    price: '44.990.000₫',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuACmY9NBIxFtWoammxsZCSYUhhvshsiz67uNCi9wtKsCG1WeUxe3SJOpysvdkThwT2Ep8US6YiKspsznR8APu5NC2ABvNc2W8b174iW9CqO81_HlKzsLjLYulYtVTZ1LmjPrcweHm8M2yXyTlvD4dI7oKArqByJmdWKEYT1PMLtlkqXehSgthmUMpK4ffSHzhH6saH3XsF-psqrdOES-o89j7X0YHTJ7ib1mSGnPfC4k1xtJ17JFi8a87d0Yu-bgRK-0iS-aWiQ-a3a',
    specs: {
      display: '7.6" Dynamic AMOLED 2X',
      displaySub: 'Folding Infinity-O, 1750 nits',
      cpu: 'Snapdragon 8 Gen 3',
      cpuSub: 'For Galaxy (4nm)',
      ramRom: '12GB LPDDR5X',
      ramRomSub: '256GB / 512GB / 1TB',
      camera: 'Main 50MP',
      cameraSub: 'Under Display Camera (UDC)',
      battery: '4,400 mAh',
      batterySub: '25W Charging / Wireless Share',
      status: 'Còn hàng',
      statusColor: 'bg-green-500'
    }
  },
  {
    name: 'Zenith Ultra 24',
    price: '28.990.000₫',
    image: 'https://lh3.googleusercontent.com/aida-public/AB6AXuDmjkBrwVPmDIbs41VoeZ7LxUxPB9x4c3A-cqJEv_uT9TLHt1fbLHf3bVSaGJjCe-eD00sTyysFn0fzRwEVOvq3cw1Bg7hzyOr-sJ-jkYJjPgnPQjEN4SJO8DdZrJUoNHquGxfNRAc1GT0ArB7_TwNt2SzHT7x1J42Ilz9B9KPvKZQpTXKiitGBArM2ARCkUOLM3PLvEH-JUACntZUgd8EqsHCG1B0UVSfuczgq9SOozxnYkSRENss_TrX_nnZUiG2o4W-4scmQHOWQ',
    specs: {
      display: '6.8" Dynamic AMOLED 2X',
      displaySub: '3000 nits Peak, LTPO 1-120Hz',
      cpu: 'Snapdragon 8 Gen 3',
      cpuSub: 'AI-enhanced Performance',
      ramRom: '16GB LPDDR5X',
      ramRomSub: '512GB / 1TB / 2TB',
      camera: 'Main 200MP',
      cameraSub: 'Dual Tele 3x/10x Optical',
      battery: '5,000 mAh',
      batterySub: '45W Super Fast / Wireless',
      status: 'Hết hàng',
      statusColor: 'bg-slate-300'
    }
  }
]
</script>

<template>
  <div class="max-w-7xl mx-auto px-8 py-16">
    <!-- Header -->
    <div class="flex flex-col md:flex-row md:items-end justify-between mb-16 gap-8">
      <div>
        <span class="text-[10px] font-black text-orange-500 tracking-[0.2em] uppercase block mb-4">Tools & Analytics</span>
        <h1 class="text-4xl font-black text-blue-950">So sánh thông số</h1>
        <p class="text-sm font-bold text-slate-400 mt-4 max-w-2xl leading-relaxed">Đưa ra quyết định chính xác bằng cách so sánh trực quan các siêu phẩm công nghệ hàng đầu hiện nay tại LUXE-TECH.</p>
      </div>
      <div class="flex items-center gap-4">
        <button @click="showDifferencesOnly = !showDifferencesOnly" 
          class="flex items-center gap-2 px-6 py-4 border-2 rounded-2xl font-black text-[10px] uppercase tracking-widest transition-all"
          :class="showDifferencesOnly ? 'bg-blue-950 text-white border-blue-950' : 'border-slate-100 text-blue-950 hover:border-blue-950'">
          <span class="material-symbols-outlined text-sm">filter_list</span>
          {{ showDifferencesOnly ? 'Hiển thị tất cả' : 'Chỉ điểm khác biệt' }}
        </button>
        <button class="flex items-center gap-2 px-6 py-4 bg-orange-500 text-white rounded-2xl font-black text-[10px] uppercase tracking-widest hover:bg-orange-600 transition-all shadow-xl shadow-orange-500/20">
          <span class="material-symbols-outlined text-sm">add</span>
          Thêm sản phẩm
        </button>
      </div>
    </div>

    <!-- Comparison Table -->
    <div class="bg-white rounded-[2.5rem] border border-slate-100 shadow-2xl shadow-slate-200/50 overflow-hidden">
      <div class="overflow-x-auto">
        <table class="w-full text-left border-collapse">
          <thead>
            <tr class="border-b border-slate-50">
              <th class="p-10 min-w-[280px] bg-slate-50/50 sticky left-0 z-10 border-r border-slate-100">
                <h3 class="text-xl font-black text-blue-950">Sản phẩm</h3>
              </th>
              <th v-for="p in products" :key="p.name" class="p-10 min-w-[320px]">
                <div class="flex flex-col items-center text-center space-y-6">
                  <div class="w-40 h-40 rounded-3xl bg-slate-50 flex items-center justify-center p-6 group">
                    <img :src="p.image" class="w-full h-full object-contain group-hover:scale-110 transition-transform duration-500">
                  </div>
                  <div>
                    <h4 class="text-lg font-black text-blue-950 leading-tight">{{ p.name }}</h4>
                    <p class="text-[10px] font-black text-orange-500 uppercase tracking-widest mt-2">{{ p.price }}</p>
                  </div>
                  <button class="w-full py-4 bg-blue-950 text-white rounded-2xl font-black text-[10px] uppercase tracking-[0.2em] hover:bg-blue-900 transition-all shadow-lg shadow-blue-950/20">Mua ngay</button>
                </div>
              </th>
            </tr>
          </thead>
          <tbody class="divide-y divide-slate-50">
            <!-- Specs Rows -->
            <tr v-for="row in [
              { key: 'display', label: 'Màn hình', icon: 'screenshot' },
              { key: 'cpu', label: 'CPU', icon: 'memory' },
              { key: 'ramRom', label: 'RAM / ROM', icon: 'storage' },
              { key: 'camera', label: 'Camera', icon: 'photo_camera' },
              { key: 'battery', label: 'Pin & Sạc', icon: 'battery_charging_full' },
              { key: 'status', label: 'Tình trạng', icon: 'verified' }
            ]" :key="row.key" class="group hover:bg-slate-50/50 transition-colors">
              <td class="p-8 bg-white sticky left-0 z-10 border-r border-slate-100 group-hover:bg-slate-50 transition-colors">
                <div class="flex items-center gap-3">
                  <span class="material-symbols-outlined text-slate-300 group-hover:text-blue-950 transition-colors">{{ row.icon }}</span>
                  <span class="text-[10px] font-black text-blue-950 uppercase tracking-widest">{{ row.label }}</span>
                </div>
              </td>
              <td v-for="p in products" :key="p.name" class="p-8">
                <template v-if="row.key !== 'status'">
                  <p class="text-sm font-black text-blue-950">{{ p.specs[row.key] }}</p>
                  <p class="text-[10px] font-bold text-slate-400 uppercase tracking-widest mt-1">{{ p.specs[row.key + 'Sub'] }}</p>
                </template>
                <template v-else>
                  <div class="flex items-center gap-2">
                    <span class="w-2 h-2 rounded-full" :class="p.specs.statusColor"></span>
                    <span class="text-[10px] font-black text-blue-950 uppercase tracking-widest">{{ p.specs.status }}</span>
                  </div>
                </template>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <!-- Service Features -->
    <div class="mt-24 grid grid-cols-1 md:grid-cols-3 gap-8">
      <div v-for="feat in [
        { name: 'Bảo hành VIP', desc: 'Thay màn hình miễn phí lần đầu và bảo hành vàng 24 tháng cho mọi flagship.', icon: 'verified_user' },
        { name: 'Thu cũ đổi mới', desc: 'Trợ giá lên đến 5.000.000₫ khi nâng cấp lên dòng máy mới nhất.', icon: 'published_with_changes' },
        { name: 'Giao nhanh 2h', desc: 'Miễn phí giao hàng hỏa tốc nội thành cho đơn hàng từ 20 triệu.', icon: 'local_shipping' }
      ]" :key="feat.name" class="p-10 border-2 border-slate-50 rounded-[2.5rem] bg-white hover:border-blue-950 transition-all group">
        <span class="material-symbols-outlined text-blue-950 mb-6 text-3xl group-hover:scale-110 transition-transform inline-block">{{ feat.icon }}</span>
        <h4 class="text-xl font-black text-blue-950 mb-3">{{ feat.name }}</h4>
        <p class="text-sm font-bold text-slate-400 leading-relaxed">{{ feat.desc }}</p>
      </div>
    </div>
  </div>
</template>
