var LOAD_NUM = 4;
var watcher;

new Vue({
    el: "#app",
    data: {
        total: 0,
        products: [],
        cart: [],
        search: "cat",
        lastSearch: "",
        loading: false,
        results: []
    },
    created: function () {
        this.onSubmit();
    },
    methods: {
        addToCart: function (product) {
            this.total += product.price;
            var found = false;
            
            for (var i = 0; i < this.cart.length; i++) {
                if (this.cart[i].id === product.id) {
                    this.cart[i].qty++;
                    found = true
                }
            }
            if (!found) {
                this.cart.push({
                    id: product.id,
                    title: product.title,
                    price: product.price,
                    qty: 1
                });
            }
            var path="/carts";
            this.$http.post(path,product);
        },
        inc: function (item) {
            item.qty++;
            this.total += item.price;
            var path="/carts";
            this.$http.post(path,item);
        },
        dec: function (item) {
            item.qty--;
            this.total -= item.price;
            if (item.qty <= 0) {
                var i = this.cart.indexOf(item);
                this.cart.splice(i, 1);
            }
            var path="/carts/".concat(item.id);
            this.$http.delete(path);
        },
        onSubmit: function () {
            this.products = [];
            this.results = [];
            this.loading = true;
            console.log("search");
            var path = "/search?q=".concat(this.search);
            this.$http.get(path).then(function (res) {
                // console.log(res);
                // setTimeout(function(){
                this.results = res.body;
                this.appendResults();
                this.lastSearch = this.search;
                this.loading = false;
                // }.bind(this), 3000);
            });
        },
        appendResults: function () {
            if (this.products.length < this.results.length) {
                var toAppend = this.results.slice(this.products.length, this.products.length + LOAD_NUM);
                this.products = this.products.concat(toAppend);
            }
        },

    },
    filters: {
        currency: function (price) {
            return "$".concat(price.toFixed(2));
        }
    },
    updated: function () {
        var sensor = document.querySelector("#product-list-bottom");
        watcher = scrollMonitor.create(sensor);
        watcher.enterViewport(this.appendResults);
    },
    beforeUpdate: function () {
        if (watcher) {
            watcher.destroy();
            watcher = null;
        }
    }
});


