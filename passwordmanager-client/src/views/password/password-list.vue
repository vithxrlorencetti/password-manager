<template>
    
  <div class="columns">
    <div class="column is-12 is-size-3">
      Lista de Senhas
    </div>
  </div>
    
  <hr />

  <div class="columns">
    <div class="column is-9">
      <input class="input" type="filtro" placeholder="Descrição da Senha">            
    </div>
    <div class="column is-3">
      <a :href="'/password/form'" class="button is-info is-fullwidth">Cadastrar</a>
    </div>
  </div>

  <hr />

  <table class="table table is-fullwidth">
    <thead class="green">
      <tr style="background: hsl(200, 53%, 20%);">
        <th style="color: #fff;">ID</th>
        <th style="color: #fff;">Senha</th>
        <th style="color: #fff;">Descrição</th>
        <th style="color: #fff;">URL</th>
        <th style="color: #fff;">Ações</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="item in passwordList" :key="item.id">
        <th>{{ item.id }}</th>
        <th>{{ item.password }}</th>
        <th>{{ item.description }}</th>
        <th>{{ item.url }}</th>
        <th> <button @click="onClickPaginaDetalhar(item.id)" class="button is-small is-warning"> Detalhar </button> </th>
      </tr>
    </tbody>
  </table>

</template>

<script lang="ts">
  import { Vue } from 'vue-class-component';
  
  import { PageRequest } from '@/model/page/page-request'
  import { PageResponse } from '@/model/page/page-response'
  
  import { Password } from '@/model/password'
  import { PasswordClient } from '@/client/password.client'
  

  export default class PasswordList extends Vue {

    private pageRequest: PageRequest = new PageRequest()
    private pageResponse: PageResponse<Password> = new PageResponse()

    passwordList: Password[] = []
    private passwordClient!: PasswordClient

    public mounted(): void {
      this.passwordClient = new PasswordClient()
      this.listarPassword()
    }

    private listarPassword(): void {
      this.passwordClient.findByFiltrosPaginado(this.pageRequest)
        .then(
          success => {
            this.pageResponse = success
            this.passwordList = this.pageResponse.content
          },
          error => console.log(error)
        )
    }

    onClickPaginaDetalhar(idPassword: number){
      this.$router.push({ name: 'password-details', params: { id: idPassword, model: 'details' } })
    }
    
  }
</script>