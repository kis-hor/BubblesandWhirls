<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout</title>
    <link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/checkout.css"/>
    <link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/header.css"/>
    <link rel="stylesheet" type="text/css" href="/BubblesandWhirls/stylesheets/footer.css"/> 
    
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <div class="checkout-container">
        <h1>Checkout</h1>
        <p class="cart-total">Cart Total: ${total}</p>
        <form method="post" action="/BubblesandWhirls/PlaceOrderServlet">
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>
            </div>
            <div class="form-group">
                <label for="payment">Payment Method:</label>
                <select id="payment" name="payment" required>
                    <option value="credit_card">Credit Card</option>
                    <option value="debit_card">Debit Card</option>
                    <option value="paypal">PayPal</option>
                </select>
            </div>
            <!-- Add more form fields for payment method if needed -->
            <button type="submit" class="btn-place-order">Place Order</button>
        </form>
    </div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>