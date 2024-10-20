# Usar a imagem oficial do Node.js
FROM node:18

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /usr/src/app

# Copiar o package.json e package-lock.json para o diretório de trabalho
COPY package*.json ./

# Instalar as dependências
RUN npm install

# Copiar todo o código para dentro do contêiner
COPY . .

# Expor a porta que o React utiliza no desenvolvimento
EXPOSE 3000

# Rodar a aplicação no modo de desenvolvimento
CMD ["npm", "start"]
