import client from './config';

const userPath = '/store/games';

const ClientUsers = {
    async createUser(data) {
        try {
            console.log(data)
            client.defaults.headers.post['Content-Type'] ='application/json;charset=utf-8';
            client.defaults.headers.post['Access-Control-Allow-Origin'] = '*';
            const response = await client.post(`${userPath}/create`, data);
            return response;
        } catch (e) {
            return e;
        }
    },

    async deleteUser(data) {
        try {
            client.defaults.headers.delete['Content-Type'] ='application/json;charset=utf-8';
            client.defaults.headers.delete['Access-Control-Allow-Origin'] = '*';
            const response = await client.delete(`${userPath}/buy/${data}`);
            return response;
        } catch (e) {
            return e;
        }
    },

    async listAll() {
        try {
            const response = await client.get(`${userPath}`);
            return response;
        } catch (e) {
            return e;
        }
    },

    async listByGame(data) {
        try {
            const response = await client.get(`${userPath}/${data}`);
            return response;
        } catch (e) {
            return e;
        }
    },
};

export default ClientUsers;