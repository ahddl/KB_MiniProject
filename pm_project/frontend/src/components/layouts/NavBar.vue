<script setup>
import { reactive, computed } from "vue";
import config from "@/config";
import MenuGroup from "./menu/MenuGroup.vue";
import AccountMenuGroup from "./menu/AccountMenuGroup.vue";

// 객체를 반응형으로 만드는 함수
let state = reactive({ isNavShow: false });

// 반응형 네비게이션 클래스 계산
let navClass = computed(() =>
  state.isNavShow ? "collapse navbar-collapse show" : "collapse navbar-collapse"
);

const toggleNavShow = () => (state.isNavShow = !state.isNavShow);
</script>

<template>
  <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
    <div class="container-fluid">
      <!-- 브랜드아이콘 클릭시 router-link로 "/" 라우터로 이동 -->
      <router-link class="navbar-brand" to="/">
        <i class="fa-solid fa-house"></i>
        Scoula
      </router-link>

      <!-- 모바일 토글 버튼 (vue 이벤트 디렉티브 활용) -->
      <button class="navbar-toggler" type="button" @click="toggleNavShow">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- 네비게이션 메뉴 -->
      <div :class="navClass" id="collapsibleNavbar">
        <!-- 자식의 바인딩 -->
        <MenuGroup :menus="config.menus" />
        <AccountMenuGroup />
      </div>
    </div>
  </nav>
</template>
