import pandas as pd
import numpy as np
import pickle
import os
from sklearn.preprocessing import MinMaxScaler
import matplotlib.patches as patches
import matplotlib.pyplot as plt
import matplotlib.image as mpimg
import matplotlib as mpl
import matplotlib.font_manager as fm
import re

df = pd.read_csv("증류주_포지션_데이터.csv", encoding="utf-8-sig")

x_line='향'
y_line='단맛'

target_list = list(df["술이름"])
name_list = list(df["술이름"])

x_list = list(df[f"{x_line}"])
y_list = list(df[f"{y_line}"])

x_list.append(0)
y_list.append(0)

x = np.array(x_list).reshape(-1,1)
y = np.array(y_list).reshape(-1,1)


scaler1 = MinMaxScaler()
scaler2 = MinMaxScaler()

scaled_x = scaler1.fit_transform(x)
scaled_y = scaler1.fit_transform(y)


fill_color = "#AC9074"
line_color = "#555555"
line_width = 2.
line_style = 'dashed'    
join_style = "miter"     
fill = True              

alpha = 1.
box_style = patches.BoxStyle.Round(pad=0., rounding_size=0.1)
bbox_transmuter = None
mutation_scale = 1.0      
mutation_aspect = None  

patch = patches.FancyBboxPatch(xy=(-0.248,-0.248),
                                width=1.496,
                                height=1.496,
                                boxstyle=box_style,
                                bbox_transmuter=bbox_transmuter,
                                mutation_scale=mutation_scale,
                                mutation_aspect=mutation_aspect,
                                # COMMON OPTIONS:
                                alpha=alpha,
                                fill=fill,
                                facecolor=fill_color,
                                hatch=None,
                                ec=line_color,
                                lw=line_width,
                                joinstyle=join_style,
                                linestyle=line_style)

plt.rcParams["figure.figsize"] = (15, 15)
plt.rcParams['axes.unicode_minus'] = False

fig, ax = plt.subplots()
fig.patch.set_alpha(0.0)
ax.patch.set_alpha(0.0)

font_name = fm.FontProperties(fname='C:/Windows/Fonts/gulim.ttc').get_name()

plt.rc('font', family=font_name) 

font = {'family' : font_name,
        'weight' : 'bold',
        'size'   : 20}

plt.plot()
plt.rc('font', **font)
plt.xlim(-0.25,1.25)
plt.ylim(-0.25,1.25)
plt.text(1.25,0.51, x_line)
plt.text(0.51,1.26, y_line)
plt.annotate('',
             ha = 'center', va = 'bottom',
             xytext = (-0.25, 0.5),
             xy = (1.25, 0.5),
             zorder=2,
             arrowprops = {'edgecolor':'black', 
              'arrowstyle':'->',
              'lw' : 2
              })

plt.annotate('',
             ha = 'center', va = 'bottom',
             xytext = (0.5, -0.25),
             xy = (0.5, 1.25),
             zorder=2,
             arrowprops = {'edgecolor':'black', 
              'arrowstyle':'->',
              'lw' : 2
              })
plt.xticks([0,0.25,0.75,1], alpha=0)
plt.yticks([0,0.25,0.75,1], alpha=0)
plt.tick_params(axis='both', length=0)

plt.gca().spines['right'].set_visible(False) #오른쪽 테두리 제거
plt.gca().spines['top'].set_visible(False) #위 테두리 제거
plt.gca().spines['left'].set_visible(False) #왼쪽 테두리 제거
plt.gca().spines['bottom'].set_visible(False)
plt.grid(True, color='gray', alpha=1, linestyle='--', lw=2,zorder=0)

for target in target_list:
    target_index = name_list.index(target)
    target_x = scaled_x[target_index]
    target_y = scaled_y[target_index]
    plt.scatter(target_x,target_y)
    img = mpimg.imread("C:/temf/1.jpg")
    plt.imshow(img,extent=[target_x[0]-0.1, target_x[0]+0.1, target_y[0]-0.1, target_y[0]+0.1],zorder=2)
    co = name_list[target_index].count(' ')
    co2 = len(re.sub(r'[^0-9]', '', name_list[target_index]))
    plt.text(target_x- (0.01 * (len(name_list[target_index]) - (0.3 * co) - (0.5 * co2))), target_y+0.1, name_list[target_index], fontsize=12)

ax.add_patch(patch)

plt.savefig('저장.png')