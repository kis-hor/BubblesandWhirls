package controller.database;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.CartModel;
import model.ContactModel;
import model.LoginModel;
import model.OrderModel;
import model.PasswordEncryptionWithAes;
import model.ProductModel;
import model.RegisterModel;
import util.StringUtils;


public class DBController {
	 
		public Connection getConnection() throws SQLException, ClassNotFoundException {

		    // Load the JDBC driver class specified by the StringUtils.DRIVER_NAME constant
		    Class.forName("com.mysql.jdbc.Driver");

		    // Create a connection to the database using the provided credentials
		    return DriverManager.getConnection("jdbc:mysql://localhost:3304/bubbles_whirls", StringUtils.HOST_NAME,
		                                      StringUtils.HOST_PASS);
		}
		
		// Register User Starts here
		public int registerStudent(RegisterModel user) {

		    try {
		        // Preparation of Registering User
		    	Connection con = getConnection();
		        PreparedStatement stmt = getConnection()
		        		.prepareStatement(StringUtils.REGISTER_USER_QUERY);//Query of Registering User
		        
		        PreparedStatement checkUsernameSt = con.prepareStatement(StringUtils.GET_USERNAME);
				checkUsernameSt.setString(1, user.getUsername());
				ResultSet checkUsernameRs = checkUsernameSt.executeQuery();
				checkUsernameRs.next();
				if(checkUsernameRs.getInt(1) > 0) {
					return -2;
				}
				
				PreparedStatement checkPhoneSt = con.prepareStatement(StringUtils.GET_PHONE);
				checkPhoneSt.setString(1, user.getPhoneNumber());
				ResultSet checkPhoneRs = checkPhoneSt.executeQuery();
				checkPhoneRs.next();
				if(checkPhoneRs.getInt(1) > 0) {
					return -4;
				}
				
				PreparedStatement checkEmailSt = con.prepareStatement(StringUtils.GET_EMAIL);
				checkEmailSt.setString(1, user.getEmail());
				ResultSet checkEmailRs = checkEmailSt.executeQuery();
				checkEmailRs.next();
				if(checkEmailRs.getInt(1) > 0) {
					return -3;
				}

		        // Setting the user information
		        stmt.setString(1, user.getUsername());
		        stmt.setString(2, user.getFirstName());
		        stmt.setString(3, user.getLastName());
		        stmt.setString(4, user.getEmail());
		        stmt.setString(5, user.getPhoneNumber());
		        stmt.setString(6, PasswordEncryptionWithAes.encrypt(
		        		user.getUsername(), user.getPassword()));
		        stmt.setString(7, user.getRole());
		        stmt.setString(8, user.getImageUrlFromPart());
		        

		        // Execute the update statement and store the number of affected rows
		        int result = stmt.executeUpdate();

		        // Check if the update was successful (i.e., at least one row affected)
		        if (result > 0) {
		            return 1; // Registration successful
		        } else {
		            return 0; // Registration failed (no rows affected)
		        }

		    } catch (ClassNotFoundException | SQLException ex) {
		        // Print the stack trace for debugging purposes
		        ex.printStackTrace();
		        return -1; // Internal error
		    }
		}
		// Register User Ends here
		
		// Login User starts here
		/**
		 * This method attempts to validate a student login by checking the username 
		 * and password against a database.
		 * 
		 * @param username The username provided by the user attempting to log in.
		 * @param password The password provided by the user attempting to log in.
		 * @return An integer value indicating the login status:
		 *         - 1: Login successful
		 *         - 0: Username or password mismatch
		 *         - -1: Username not found in the database
		 *         - -2: Internal error (e.g., SQL or ClassNotFound exceptions)
		 * @throws SQLException if a database access error occurs.
		 * @throws ClassNotFoundException if the JDBC driver class is not found.
		 */
		public int getUserLoginInfo(LoginModel loginModel) {
		    // Try-catch block to handle potential SQL or ClassNotFound exceptions
		    try {
		        // Prepare a statement using the predefined query for login check
		        PreparedStatement st = getConnection()
		        		.prepareStatement(StringUtils.USER_LOGIN_QUERY_CHECK);
//		        System.out.println(st);
		        // Set the username in the first parameter of the prepared statement
		        st.setString(1, loginModel.getUsername());
		        
	
		        // Execute the query and store the result set
		        ResultSet result = st.executeQuery();
		        
		        // Check if there's a record returned from the query
		        if (result.next()) {
		            // Get the username from the database
		        	String userDb = result.getString(StringUtils.USER_NAME);

		            // Get the password from the database
		        	String encryptedPwd = result.getString(StringUtils.PASSWORD);
		        	
		        	// Get the role of the user
		        	
		        	String role = result.getString("role");
		        	
		        	String userId = result.getString("user_id");
		        	
		        			        	
		        	
		            // Check if the username and password match the credentials from the database
		        	
		            // For regular users, decrypt the password and compare
		            if (role.equals("user")) {
		                String decryptedPwd = PasswordEncryptionWithAes.decrypt(encryptedPwd, userDb);
		                if (userDb.equals(loginModel.getUsername()) && decryptedPwd.equals(loginModel.getPassword())) {
		                    return 1; // Regular user login successful
		                } else {
		                    return 0; // Username or password mismatch
		                }
		            } else {
		                // For admin users, compare passwords directly
		            	
		                if (encryptedPwd.equals(loginModel.getPassword())) {
		                    return 2; // Admin login successful
		                } else {
		                    return 0; // Username or password mismatch
		                }
		            }

		        } else {
		            // Username not found in the database, return -1
		            return -1;
		        }

		    // Catch SQLException and ClassNotFoundException if they occur
		    } catch (SQLException | ClassNotFoundException ex) {
		        // Print the stack trace for debugging purposes
		        ex.printStackTrace();
		        // Return -2 to indicate an internal error
		        return -2;
		    }
		}
		public int getUserIdByUserName(String username) {
			
				try {
			        // Prepare a statement to retrieve user_id based on username
					Connection con = getConnection();
			        PreparedStatement st = con.prepareStatement("SELECT user_id FROM users WHERE user_name = ?");
			        st.setString(1, username);

			        // Execute the query and store the result set
			        ResultSet result = st.executeQuery();
			        
			        // Check if there's a record returned from the query
			        if (result.next()) {
			            // Retrieve the user_id from the result set
			            int userId = result.getInt("user_id");
			            return userId;
			        } else {
			            // No user found with the given username, return -1 to indicate error
			            return -1;
			        }
			    } catch (SQLException | ClassNotFoundException ex) {
			        // Print the stack trace for debugging purposes
			        ex.printStackTrace();
			        // Return -2 to indicate an internal error
			        return -2;
			    }
		}
		
		public RegisterModel getUserInfo(String username) {
			try(Connection con = getConnection()) {
				PreparedStatement stmt = con.prepareStatement(StringUtils.GET_USER_DETAIL);
				stmt.setString(1, username);
				ResultSet result = stmt.executeQuery();
				RegisterModel user = new RegisterModel();
				
				if(result.next()) {
					user.setUsername(result.getString("user_name"));
					user.setFirstName(result.getString("first_name"));
					user.setLastName(result.getString("last_name"));
					user.setEmail(result.getString("email"));
					user.setPhoneNumber(result.getString("phone_number"));
					user.setImageUrlFromPart(result.getString("user_image"));
					
				}
				return user;	
			}catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
				return null;
			}
		}	
		
		public int updateUserInfo(RegisterModel registerModel) {
			try (Connection con = getConnection()) {
				PreparedStatement st = con.prepareStatement(StringUtils.UPDATE_USER);
				
				st.setString(1, registerModel.getFirstName());
				st.setString(2, registerModel.getLastName());
				st.setString(3,registerModel.getEmail());
				st.setString(4, registerModel.getPhoneNumber());
				st.setString(5, registerModel.getUsername());
				
				int result = st.executeUpdate();
				System.out.println(registerModel.getFirstName());
				System.out.println(registerModel.getLastName());
				System.out.println(registerModel.getEmail());
				System.out.println(registerModel.getPhoneNumber());
				System.out.println(registerModel.getUsername());
				System.out.println("db result="+result);
				return result;//1 or 0
			
			} catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace(); // Log the exception for debugging
				return -1;
			}
		}
		// Login User Ends here
		public int addProduct(ProductModel productModel) {
			try(Connection con = getConnection()) {
				PreparedStatement st = con.prepareStatement(StringUtils.ADD_PRODUCT);
				
//				st.setInt(1, productModel.getProductId());
				st.setString(1, productModel.getProductName());
				st.setString(2, productModel.getProductImageUrl());
				st.setInt(3, productModel.getProductPrice());
				st.setString(4, productModel.getProductDescription());
				st.setInt(5, productModel.getProductInventory());
				st.setString(6, productModel.getProductCategory());
				
				int result = st.executeUpdate();
				return result > 0 ? 1 : 0;
				
			}catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
				return -1;
				
			}
			
		}
		
		public ArrayList<ProductModel> getAllProductsInfo(){
			try {
				PreparedStatement stmt = getConnection().prepareStatement(StringUtils.GET_ALL_PRODUCTS_INFO);
				
				ResultSet result = stmt.executeQuery();
				
				ArrayList<ProductModel> products = new ArrayList<ProductModel>();
				
				while(result.next()) {
					ProductModel product = new ProductModel();
					product.setProductId(result.getInt("product_id"));
					product.setProductName(result.getString("product_name"));
					product.setProductImageUrl(result.getString("product_image_path"));
					product.setProductPrice(result.getInt("product_price"));
					product.setProductDescription(result.getString("product_description"));
					product.setProductInventory(result.getInt("inventory"));
					
					products.add(product);
				}
				
				return products;
			}catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
				return null;
			}
		}
		
		
		public ProductModel getProductInfo(String productId) {
			try(Connection con = getConnection()) {
				PreparedStatement pdt = con.prepareStatement(StringUtils.GET_PRODUCT_INFO);
				pdt.setString(1, productId);
				ResultSet result = pdt.executeQuery();
				ProductModel product = new ProductModel();
				
				if(result.next()) {
					product.setProductId(result.getInt("product_id"));
					product.setProductName(result.getString("product_name"));
					product.setProductImageUrl(result.getString("product_image_path"));
					product.setProductPrice(result.getInt("product_price"));
					product.setProductDescription(result.getString("product_description"));
					product.setProductInventory(result.getInt("inventory"));
					product.setProductCategory(result.getString("product_category"));
						
				}
				return product;	
			}catch(SQLException | ClassNotFoundException ex) {
				ex.printStackTrace();
				return null;
			}
		
		}
		
		public int deleteProductInfo(String product_id) {
			try (Connection con = getConnection()) {
				PreparedStatement st = con.prepareStatement(StringUtils.DELETE_PRODUCT);
				st.setString(1, product_id);
				return st.executeUpdate();
			} catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace(); // Log the exception for debugging
				return -1;
			}
		}
		
		public int updateProductInfo(ProductModel productModel) {
			try (Connection con = getConnection()) {
				PreparedStatement pdt = con.prepareStatement(StringUtils.UPDATE_PRODUCT);
				
				pdt.setString(1, productModel.getProductName());
				pdt.setInt(2, productModel.getProductPrice());
				pdt.setString(3, productModel.getProductDescription());
				pdt.setInt(4, productModel.getProductInventory());
				pdt.setString(5, productModel.getProductCategory());
				pdt.setInt(6, productModel.getProductId());
				
				int result = pdt.executeUpdate();
				
				return result;//1 or 0
			} catch (SQLException | ClassNotFoundException ex) {
				ex.printStackTrace(); // Log the exception for debugging
				return -1;
			}
		}
		
		public ArrayList<RegisterModel> getAllUserInfo(){
            try {
                PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM users");
                ResultSet result = stmt.executeQuery();

                ArrayList<RegisterModel> users = new ArrayList<RegisterModel>();

                while(result.next()) {
                	RegisterModel user = new RegisterModel();
                    user.setFirstName(result.getString("first_name"));
                    user.setLastName(result.getString("last_name"));
                    user.setEmail(result.getString("email"));
                    user.setPhoneNumber(result.getString("phone_number"));
                    user.setUsername(result.getString("user_name"));
                    user.setPassword(result.getString("password"));
                    user.setRole(result.getString("role"));
                    user.setImageUrlFromPart(result.getString("user_image"));
                    users.add(user);
                }
                return users;
            }catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
                return null;
            }
		}
		
    		public int deleteUserInfo(String username) {
    			try (Connection con = getConnection()) {
    				PreparedStatement st = con.prepareStatement(StringUtils.DELETE_USER);
    				st.setString(1, username);
    				return st.executeUpdate();
    			} catch (SQLException | ClassNotFoundException ex) {
    				ex.printStackTrace(); // Log the exception for debugging
    				return -1;
    			}
    		}
    		
    		
    		
    		public ArrayList<OrderModel> getAllOrdersInfo(){
    			try {
    				PreparedStatement stmt = getConnection().prepareStatement(StringUtils.GET_ALL_ORDERS_INFO);
    				
    				ResultSet result = stmt.executeQuery();
    				
    				ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
    				
    				while(result.next()) {
    					OrderModel order = new OrderModel();
    					order.setOrderId(result.getInt("order_id"));
    					order.setOrderDate(result.getDate("order_date").toLocalDate());
    					order.setOrderTotal(result.getInt("order_total"));
    					order.setDeliveryStatus(result.getString("delivery_status"));
    					order.setOrderStatus(result.getString("order_status"));
    					order.setOrderQuantity(result.getInt("order_quantity"));
    					order.setUsername(result.getString("user_name"));
    					order.setEmail(result.getString("email"));
    					
    					orders.add(order);
    				}
    				
    				return orders;
    			}catch(SQLException | ClassNotFoundException ex) {
    				ex.printStackTrace();
    				return null;
    			}
    		}
    
    		
    		
    		
    		public ArrayList<OrderModel> getAllUserOrderInfo(String userId){
    			try {
    			PreparedStatement stmt = getConnection().prepareStatement(StringUtils.GET_ALL_USER_ORDERS);
    			stmt.setString(1, userId);
    			ResultSet result = stmt.executeQuery();
    			
    			ArrayList<OrderModel> orders = new ArrayList<OrderModel>();
    			while(result.next()) {
    				OrderModel order = new OrderModel();
    				order.setDeliveryStatus(result.getString("delivery_status"));
    				order.setOrderStatus(result.getString("order_status"));
    				order.setOrderDate(result.getDate("order_date").toLocalDate());
    				order.setOrderId(result.getInt("order_id"));	
    				order.setOrderQuantity(result.getInt("order_quantity"));
    				order.setUsername(result.getString("user_name"));
    				order.setEmail(result.getString("email"));
    				order.setProductId(result.getInt("product_id"));
    				order.setProductName(result.getString("product_name"));
    				order.setProductPrice(result.getInt("product_price"));
    				order.setProductImageUrl(result.getString("product_image_path"));
    				order.setOrderTotal(result.getInt("order_total"));
    				orders.add(order);
    			}
    			
    			return orders;
    			}catch(SQLException | ClassNotFoundException ex) {
    				ex.printStackTrace();
    				return null;
    		}
    		}
    		
    		public int updateOrderInfo(OrderModel orderModel) {
    			try (Connection con = getConnection()) {
    				PreparedStatement pdt = con.prepareStatement(StringUtils.UPDATE_ORDER);
    				
    				pdt.setString(1, orderModel.getDeliveryStatus());
    				pdt.setString(2, orderModel.getOrderStatus());
    				pdt.setInt(3, orderModel.getOrderId());
    				
    				
    				int result = pdt.executeUpdate();
    				
    				return result;//1 or 0
    			} catch (SQLException | ClassNotFoundException ex) {
    				ex.printStackTrace(); // Log the exception for debugging
    				return -1;
    			}
    		}
    		
    		public OrderModel getOrderInfo(String orderId) {
                try(Connection con = getConnection()) {
                    PreparedStatement st = con.prepareStatement(StringUtils.GET_ORDER_INFO);
                    st.setString(1, orderId);
                    ResultSet result = st.executeQuery();
                    OrderModel order = new OrderModel();

                    if(result.next()) {
                        order.setDeliveryStatus(result.getString("delivery_status"));
                        order.setOrderStatus(result.getString("order_status"));
                        order.setOrderDate(result.getDate("order_date").toLocalDate());
                        order.setOrderId(result.getInt("order_id"));
                        order.setOrderQuantity(result.getInt("order_quantity"));
                        order.setUsername(result.getString("user_name"));
                        order.setEmail(result.getString("email"));
                        order.setProductId(result.getInt("product_id"));
                        order.setProductName(result.getString("product_name"));
                        order.setProductPrice(result.getInt("product_price"));
                        order.setProductImageUrl(result.getString("product_image_path"));
                        order.setPaymentOption(result.getString("payment_option"));
                        order.setShippingAddress(result.getString("shipping_address"));
                    }
                    return order;
                }catch(SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    return null;
                }

            }
    		public int addToCart(CartModel cartItem, int userId) {
    	        try (Connection con = getConnection()) {
    	            PreparedStatement st = con.prepareStatement(StringUtils.ADD_TO_CART);
    	 
    	            st.setInt(1, cartItem.getProductId());
    	            st.setInt(2, cartItem.getQuantity());
    	            st.setInt(3, userId);
    	            
    	            int result = st.executeUpdate();
    	            return result > 0 ? 1 : 0;
    	        } catch (SQLException | ClassNotFoundException ex) {
    	            ex.printStackTrace();
    	            return -1;
    	        }
    	    }
    		public ArrayList<CartModel> getCartItemsByUserId(int userId) {
    		    ArrayList<CartModel> cartItems = new ArrayList<>();

    		    try {
    		        // Prepare a SQL query to retrieve cart items with product details for the given user ID
    		    	 String query = "SELECT c.cart_id, p.product_name, c.product_id, c.cart_quantity, p.product_price " +
    	                       "FROM cart_item c " +
    	                       "JOIN product p ON c.product_id = p.product_id " +
	    	                       "WHERE c.user_id = ?";
	    	        PreparedStatement statement = getConnection().prepareStatement(query);
	    	        statement.setInt(1, userId);
	
	    	        // Execute the query and retrieve the result set
	    	        ResultSet resultSet = statement.executeQuery();
	
	    	        // Iterate over the result set to create CartModel objects for each cart item
	    	        while (resultSet.next()) {
	    	            CartModel cartItem = new CartModel();
	    	            cartItem.setCartId(resultSet.getInt("cart_id"));
	    	            cartItem.setProductId(resultSet.getInt("product_id"));
	    	            cartItem.setProductName(resultSet.getString("product_name"));
	    	            cartItem.setQuantity(resultSet.getInt("cart_quantity"));
	    	            cartItem.setProductPrice(resultSet.getInt("product_price"));
	    	            
	    	            // Add the cart item to the list
	    	            cartItems.add(cartItem);
	    		      }
	    	        return cartItems;
    		    } catch (SQLException | ClassNotFoundException ex) {
    		        ex.printStackTrace();
    		        return null;
    		    } 
    		}
    		
    		public void addOrderItem(int orderId, int userId, List<CartModel> cartItems) throws SQLException, ClassNotFoundException {
    		    try {
    		        Connection con = getConnection();
    		        String query = "INSERT INTO order_item (order_id, user_id, product_id, order_quantity) VALUES (?, ?, ?, ?)";
    		        PreparedStatement stmt = con.prepareStatement(query);

    		        for (CartModel cartItem : cartItems) {
    		            stmt.setInt(1, orderId);
    		            stmt.setInt(2, userId);
    		            stmt.setInt(3, cartItem.getProductId());
    		            stmt.setInt(4, cartItem.getQuantity());
    		            stmt.addBatch();
    		        }
    		        stmt.executeBatch();
    		    } catch (SQLException | ClassNotFoundException ex) {
    		        ex.printStackTrace();
    		    }
    		}
    		
    		public int addOrder(int userId, int orderTotal) throws SQLException, ClassNotFoundException {
    		    try {
    		        // Get the current date and time for the order
    		        LocalDateTime orderDateTime = LocalDateTime.now();

    		        // Prepare the SQL query for inserting the order
    		        String query = "INSERT INTO orders (user_id, order_date, order_total, delivery_status, order_status) VALUES (?, ?, ?, ?, ?)";
    		        Connection con = getConnection();
    		        PreparedStatement stmt = con.prepareStatement(query);

    		        // Set the values for the parameters
    		        stmt.setInt(1, userId);
    		        stmt.setObject(2, orderDateTime);
    		        stmt.setDouble(3, orderTotal);
    		        stmt.setString(4, "pending"); // Set delivery status to pending
    		        stmt.setString(5, "pending"); // Set order status to pending

    		        // Execute the update statement
    		        int result = stmt.executeUpdate();

    		        // Return the number of rows affected (1 if successful, 0 otherwise)
    		        return result;

    		    } catch (ClassNotFoundException | SQLException ex) {
    		        // Print the stack trace for debugging purposes
    		        ex.printStackTrace();
    		        return -1; // Internal error
    		    }
    		}
    		
    		public void clearCart(int userId) throws SQLException, ClassNotFoundException {
    		    try (Connection con = getConnection();
    		         PreparedStatement stmt = con.prepareStatement("DELETE FROM cart_item WHERE user_id = ?")) {
    		        stmt.setInt(1, userId);
    		        stmt.executeUpdate();
    		    } catch (SQLException | ClassNotFoundException ex) {
    		        ex.printStackTrace();
    		    } 
    		}
    		
    		public int deleteCart(int deleteCartId) {
    		    try (Connection con = getConnection()) {
    		        PreparedStatement st = con.prepareStatement("DELETE FROM cart_item WHERE cart_id = ?");
    		        st.setInt(1, deleteCartId);
    		        return st.executeUpdate();
    		    } catch (SQLException | ClassNotFoundException ex) {
    		        ex.printStackTrace(); // Log the exception for debugging
    		        return -1;
    		    }
    		} 
    		
    		
    		
    		public ArrayList<ProductModel> searchProduct(String productName){
    			try {
                    PreparedStatement stmt = getConnection().prepareStatement("SELECT * FROM product WHERE product_name LIKE ?");
                    
                    stmt.setString(1, "%" + productName + "%");
                    ResultSet result = stmt.executeQuery();
                    
                    ArrayList<ProductModel> searchResults = new ArrayList<ProductModel>();
                    
                    while (result.next()) {
                        // Assuming you have a Product class with appropriate constructors and getters/setters
                        ProductModel product = new ProductModel();
                        product.setProductId(result.getInt("product_id"));
                        product.setProductName(result.getString("product_name"));
                        product.setProductImageUrl(result.getString("product_image_path"));
                        product.setProductPrice(result.getInt("product_price"));
                        // Set other attributes of the product as needed
                        searchResults.add(product);
                    }
                    return searchResults;
                }catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    return null;
                }
    		}
    		public int addMessage(ContactModel contactModel) {
                try {
                    Connection con = getConnection();
                    PreparedStatement stmt = getConnection()
                            .prepareStatement("INSERT INTO contact(name,email,message) VALUES(?,?,?)");
                    stmt.setString(1, contactModel.getName());
                    stmt.setString(2, contactModel.getEmail());
                    stmt.setString(3, contactModel.getMessage());


                    int result = stmt.executeUpdate();
                    return result > 0 ? 1 : 0;


                }catch (ClassNotFoundException | SQLException ex) {
                    // Print the stack trace for debugging purposes
                    ex.printStackTrace();
                    return -1;
                }
            }
    		
		}

