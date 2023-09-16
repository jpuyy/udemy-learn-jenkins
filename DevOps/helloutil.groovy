def createLunch(Map params = [:]) {
    def lunch = params.get("lunch")
    def price = params.get("price")
    def order = """[
        {
            "price": ${price},
            "lunch": ${lunch}
        }
    ]"""

    echo "This is your order:"
    echo "${order}"
}

return this