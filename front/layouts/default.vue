<template>
  <div id="app" class="app container-fluid">
    <div id="nav">
      <Nav :base-url="baseUrl" />
    </div>
    <main id="main" class="router-view">
      <Nuxt />
    </main>
    <div id="footer">
      <Footer />
    </div>
  </div>
</template>

<script>
import Nav from '@/components/navAndFooter/Nav'
import Footer from '@/components/navAndFooter/Footer'
export default {
  name: 'DefaultLayout',
  components: { Footer, Nav },
  data() {
    return {
      baseUrl: 'http://localhost:3000/',
    }
  },
}
</script>
<style>
@media (min-width: 991.98px) {
  div.app {
    grid-template-rows: 17vh 1fr 11vh;
  }
  /* .layer-top-exercise {
      height: 42vh !important;
    } */
}
div.app {
  display: grid;

  grid-template-areas:
    'nav'
    'main'
    'foot';
}
#nav {
  grid-area: nav;
}
#main {
  grid-area: main;
}
#footer {
  grid-area: foot;
}
</style>
