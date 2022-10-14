<template>
    
    <div class="columns is-half">
        <div class="column is-12 is-size-3" v-if="model !='details' && model != 'edit'">
            Cadastrar Senha
        </div>
    </div>
    <div class="columns is-half">
        <div class="column is-12 is-size-3" v-if="model ==='details'">
            Detalhar Senha
        </div>
    </div>
    <div class="columns is-half">
        <div class="column is-12 is-size-3" v-if="model === 'edit'">
            Editar Senha
        </div>
    </div>

    <hr />

    <div class="columns" v-if="notification.ativo">
        <div class="column is-12">
            <div :class="notification.classe">
                <button @click="onClickFecharNotificacao()" class="delete" ></button>
                {{ notification.mensagem }}
            </div>
        </div>
    </div>

    <div class="columns campo" >
        <div class="column is-4 is-size-3">
            <label class="label">Senha</label>
            <div class="control">
                <input :disabled="model === 'details'" class="input is-normal" type="text" v-model="password.password" placeholder="Senha...">
            </div>
        </div>
    </div>

    <div class="columns campo">
        <div class="column is-4 is-size-3">
            <label class="label">Descrição</label>
            <div class="control">
                <input :disabled="model === 'details'" class="input is-normal" type="text" v-model="password.description" placeholder="Descrição...">
            </div>
        </div>
    </div>

    <div class="columns campo">
        <div class="column is-4 is-size-3">
            <label class="label">URL</label>
            <div class="control">
                <input :disabled="model === 'details'" class="input is-normal" type="text" v-model="password.url" placeholder="URL do site...">
            </div>
        </div>
    </div>

     <hr />

    <div class="columns">
        
        <div class="column is-2">
            <a href="/" class="button is-fullwidth is-info">Voltar</a>
        </div>
        <div class="column is-2" v-if="model === 'details'">
            <button class="button is-fullwidth is-warning" @click="onClickPaginaEditar(password.id)">Editar</button>
        </div>
        <div class="column is-2" v-if="model === 'edit'">
            <button class="button is-fullwidth is-success" @click="onClickEditar()">Salvar</button>
        </div>
        <div class="column is-2" v-if="model === 'details'">
            <button class="button is-fullwidth is-danger" @click="onClickDeletar()">Excluir</button>
        </div>
        <div class="column is-2" v-if="model != 'edit' && model != 'details'">
            <button class="button is-fullwidth is-success" @click="onClickCadastrar()">Cadastrar</button>
        </div>
    </div>

</template>

<script lang="ts">
    import { Vue } from 'vue-class-component'
    import { Prop } from 'vue-property-decorator'

    import { Password } from '@/model/password'
    import { Notification } from '@/model/notification'
    import { PasswordClient } from '@/client/password.client'

    export default class PasswordForm extends Vue {

        passwordClient!: PasswordClient
        password : Password = new Password()
        notification : Notification = new Notification()
    
        @Prop({ type: Number, required: false })
        private readonly id!: number

        @Prop({ type: String, default: false })
        public model!: string

        public mounted(): void {
            this.passwordClient = new PasswordClient()
            this.carregarPassword();
            console.log(this.id)
            console.log(this.model)
        }
        
        onClickCadastrar(): void {
            this.passwordClient.insert(this.password).then(success => {
                this.notification = this.notification.new(true, 'notification is-success','A senha foi Cadastrado com sucesso')
                console.log(this.password)
                this.onClickLimpar()
            }, error => {
                this.notification = this.notification.new(true, 'notification is-danger', 'Error: ' + error)
                console.log(this.password)
                this.onClickLimpar()
            })
        }

        onClickEditar(): void {
            this.passwordClient.update(this.password).then(sucess => {
            this.notification = this.notification.new(true, 'notification is-success',
                'A senha foi editada com sucesso')
            }, error => {
            this.notification = this.notification.new(true, 'notification is-danger', 'Error: ' + error)
            })
        }

        public onClickPaginaEditar(idPassword: number){
            this.$router.push({ name: 'password-edit', params: { id: idPassword, model: 'edit' } })
        }

        private carregarPassword(): void {
            this.passwordClient.findById(this.id).then(value => {
                this.password = value
            }).catch(reason => {
                this.notification = reason
                console.log(this.notification)
            })
        }

        onClickFecharNotificacao(): void {
            this.notification = new Notification()
        }

        private onClickLimpar(): void {
            this.password = new Password()
        }

        onClickDeletar(): void {
            this.passwordClient.delete(this.password).then(sucess => {
            this.notification = this.notification.new(true, 'notification is-success',
                'A senha foi excluida com sucesso')
            }, error => {
            this.notification = this.notification.new(true, 'notification is-danger',
                'Error: ' + error)
            })
        }

        // private created(): void { }
    }
</script>