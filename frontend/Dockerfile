# File ./Dockerfile
FROM node:20.11.1-alpine3.19 AS build

# Définit le répertoire de travail
WORKDIR /app

# Copie les fichiers de configuration de package
COPY package.json .
COPY package-lock.json .

# Installe les dépendances
RUN yarn install

# Copie le reste des fichiers de l'application
COPY . .

# Construire l'application pour la production
RUN yarn run build

# Étape 2 : Exécution de l'application
# Ici, nous utilisons l'image Nginx pour servir les fichiers statiques
FROM nginx:alpine

# Copie les fichiers construits dans le répertoire de Nginx
COPY --from=build /app/dist/. /usr/share/nginx/html

RUN rm /etc/nginx/conf.d/default.conf
COPY ./nginx/nginx.conf /etc/nginx/conf.d
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]