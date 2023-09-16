def createLunch(Map params = [:]) {
    def lunch = params.get("lunch")
    def price = params.get("price")

    String drinkType = params.get('drink', null)
    def order = """[
        {
            "price": ${price},
            "lunch": ${lunch}
        }
    ]"""

    if (!drinkType) {
        order = """[
            {
                "price": ${price},
                "lunch": ${lunch},
                "drink": ${drinkType}

            }
        ]"""
    }

    echo "This is your order:"
    echo "${order}"
}

return this