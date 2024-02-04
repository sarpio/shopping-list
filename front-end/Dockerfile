# FROM node:alpine AS angular
# WORKDIR /app
# COPY . .
# RUN npm install
# RUN npm install -g npm@10.4.0 
# RUN npm run build
# FROM nginx:stable
# COPY --from=angular /app/dist/front-end/browser /usr/share/nginx/html
# COPY /nginx.conf /etc/nginx/conf.d/default.conf
# EXPOSE 4200

FROM node:alpine AS angular
WORKDIR /app
COPY . /app/
RUN npm update
RUN npm install -g npm
RUN npm install -g @angular/cli
RUN npm install -y
RUN ng build
CMD [ "npx", "http-server", "-p", "4200", "-c-1", "/dist/front-end/browser" ]
EXPOSE 4200