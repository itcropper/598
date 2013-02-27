# This is a take-home exam for CS 360, Spring 2012.

# This script will run some queries on the winestore database stored
# on the MySQL server on ilab.cs.byu.edu.  You will need to run it
# from a CS department computer to gain access to the database.

# Fill in the appropriate SQL statements for each of the 6 queries
# given below, in the methods named: stock, extra, types, total,
# orders, and best.  The query you need to make is documented in the
# code, and the results will be printed out for you.  You only need to
# change the lines that set the "sql" variable in each method.

# You should not need to make nested queries, and the entire script
# should run in less than a second.

# Please use the entity-relationship diagram given here:		

# http://ilab.cs.byu.edu/cs360/code/winestore/winestore.png

# as a guide to the database tables.  Note, the ID is what makes a
# wine distinct -- a wine may have the same name and year, but if the
# wine ID is different then it is technically a different wine.

# You may use any books or online resources you need to help you with
# the SQL queries.  You may not work with other students or get help
# from anyone else.  You may ask the instructor questions to clarify
# anything that is unclear.


# To install pymsql on the CS machines:
#   1) easy_install --user pip
#   2) ~/.local/bin/pip install pymysql
#   3) fill in your home directory below
home = '/users/ugrad/i/icropper/build/pymysql/build'
#   4) Uncomment the following lines
import sys
sys.path.append(home + '/lib')


# To install pymysql on your own machine:
#   1) sudo pip install pymysql


import sys
import pymysql

class Query:
    def __init__(self):
        self.host = 'ilab.cs.byu.edu'
        self.user = 'guest'
        self.passwd = 'RUG8cQhz'
        self.db = 'winestore'
        self.port = 3306

        # connect to the MySQL server
        self.conn = pymysql.connect(host=self.host, port=self.port,
                                    user=self.user, passwd=self.passwd,
                                    db=self.db)

    def stock(self):
        # Shows all wine in stock (in inventory with on_hand > 0).
        # 
        # Format the results as:
        # year name: price (quantity_on_hand)
        # 
        # Order by: year, wine name, price
        print ""
        print "*** 1 ***"


        sql = "SELECT wine.year, wine_name, inventory.cost, inventory.on_hand FROM wine NATURAL JOIN inventory WHERE inventory.on_hand > 0 ORDER BY wine.year, wine.wine_name, inventory.cost ;"

        cur = self.conn.cursor()
        cur.execute(sql)	
	for r in cur:
            print "%d %s: $%.2f (%d)" % (r[0], r[1], r[2], r[3])
        cur.close()
        
    def extra(self):
        # Shows all wine for which there is more than one shipment in
        # stock (there is more than one entry in the inventory table with
        # on_hand > 0).
        #
        # Format the results as:
        # year name: quantity_on_hand
        #
        # Order by: wine name, year
        print ""
        print "*** 2 ***"
        
        sql = "SELECT DISTINCT wine.year, wine.wine_name, inventory.on_hand FROM wine INNER JOIN inventory USING(wine_id) WHERE inventory.on_hand > 0 AND inventory.inventory_id > 1 ORDER BY wine.wine_name, wine.year ;"


        cur = self.conn.cursor()
        cur.execute(sql)
	
	#for r in cur:
	#	print r
	
	for r in cur:
		print "%d %s: %d" % (r[0], r[1], r[2])
        cur.close()

    def types(self):
        # Shows all wine types that are in stock (one row per type).
        # 
        # Format the results as:
        # type: quantity_on_hand
        #
        # Order by: none
        print ""
        print "*** 3 ***"
        
        sql = "SELECT wine_typ ;"

	
	cur = self.conn.cursor()
        cur.execute(sql)
        for r in cur:
            print "%s: %d" % (r[0], r[1])
        cur.close()

    def total(self):
        # Shows total bottles of wine on hand from the inventory.
        #
        # Format the results as:
        # total
        print ""
        print "*** 4 ***"
	
        sql = "SELECT SUM(on_hand) FROM inventory ;"

        cur = self.conn.cursor()
        cur.execute(sql)
        for r in cur:
            print "%d" % (r[0])
        cur.close()

    def orders(self):
        # Shows an order history for each customer, alphabetized by
        # last name then first name. The order history consists of
		# the wine purchased with each order.
        #
        # Format the results as:
        # firstname surname: wine_name quantity price
        #
        # Order by: surname, first name, wine name, quantity, price
        print ""
        print "*** 5 ***"

        sql = "SELECT DISTINCT customer.firstname, customer.surname, wine.wine_name, items.qty, items.price FROM customer LEFT JOIN orders USING (cust_id) LEFT JOIN items USING (order_id) JOIN wine ORDER BY customer.surname, customer.firstname ;"

        cur = self.conn.cursor()
        cur.execute(sql)
	for r in cur:
		print r
		#print "%s %s: %s %d $%.2f" % (r[0], r[1], r[2], r[3], r[4])
        cur.close()

    def best(self):
        # Shows all customers, ordered by the total amount spent at the
        # store on all orders.  The customer who spent the most should be
        # shown first.
        #
        # Format the results as:
        # firstname surname: amount
        #
        # Order by: amount (descending order)
        print ""
        print "*** 6 ***"

        sql = "SELECT customer.firstname, customer.surname SUM(SELECT items.price FROM items JOIN order USING (customer.cust_id))FROM customer ORDER BY SUM(SELECT items.price FROM items JOIN order USING (customer.cust_id)) ;"
        cur = self.conn.cursor()
        cur.execute(sql)
        for r in cur:
            print "%s %s: $%.2f" % (r[0], r[1], r[2])
        cur.close()

    def close(self):
        self.conn.close()


q = Query()

# examine wines in stock
q.stock()
q.extra()
#q.types()
q.total()

# examine customer orders
q.orders()
#q.best()

q.close()
