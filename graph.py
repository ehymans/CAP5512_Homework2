import pandas as pd
import matplotlib.pyplot as plt

# Replace 'your_file.csv' with the path to your actual CSV file
csv_file_path = 'royalroad2_summary.csv'

# Read the CSV file
data = pd.read_csv(csv_file_path)

# Assuming the first two columns have headers 'Column1' and 'Column2'
# If they don't, you can use data.columns[0] and data.columns[1] instead
x = data[data.columns[0]]
y = data[data.columns[1]]

# Create the plot
plt.figure(figsize=(10, 6))  # Adjust the figure size as needed
plt.plot(x, y, marker='o')  # You can change the marker style if needed

plt.title('Graph of the first two columns')
plt.xlabel(data.columns[0])  # Set the x-axis label to the first column header
plt.ylabel(data.columns[1])  # Set the y-axis label to the second column header

plt.grid(True)
plt.show()
