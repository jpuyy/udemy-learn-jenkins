def createLunch(Map params = [:]) {
    def lunch = params.get("lunch")
    def price = params.get("price")
    def order = """[
        {
            "price": ${price},
            "lunch": ${lunch}
        }
    ]"""

    writeJSON file: ".tmp/order.json", json: "${order}"
}

return this